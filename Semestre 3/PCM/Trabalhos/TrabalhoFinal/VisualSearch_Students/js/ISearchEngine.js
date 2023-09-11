'use strict';

class ISearchEngine {
    constructor(dbase) {
        this.allpictures = new Pool(3000);
        this.colors = ["red", "orange", "yellow", "green", "Blue-green", "blue", "purple", "pink", "white", "grey", "black", "brown"];
        this.redColor = [204, 251, 255, 0, 3, 0, 118, 255, 255, 153, 0, 136];
        this.greenColor = [0, 148, 255, 204, 192, 0, 44, 152, 255, 153, 0, 84];
        this.blueColor = [0, 11, 0, 0, 198, 255, 167, 191, 255, 153, 0, 24];
        this.categories = ["beach", "birthday", "face", "indoor", "manmade/artificial", "manmade/manmade","manmade/urban", "marriage", "nature", "no_people", "outdoor", "party", "people", "snow"];
        this.XML_file = dbase;
        this.XML_db = new XML_Database(dbase);
        this.LS_db = new LocalStorageXML();
        this.num_Images = 100;
        this.numshownpic = 35;
        this.imgWidth = 190;
        this.imgHeight = 140;
        this.aux = 0;
    }

    init(cnv) {
        //this.databaseProcessing(cnv);
    }

    // method to build the database which is composed by all the pictures organized by the XML_Database file
    // At this initial stage, in order to evaluate the image algorithms, the method only compute one image.
    // However, after the initial stage the method must compute all the images in the XML file
    databaseProcessing (cnv) {
        let h12color = new ColorHistogram(this.redColor, this.greenColor, this.blueColor);
        let colmoments = new ColorMoments();

        let self = this;

        this.categories.forEach(function(category) 
        {    
            let paths = self.XML_db.SearchXMLByKeyword(category, self.num_Images);
            let dominantColors = self.XML_db.SearchXMLByColor(category, self.num_Images);

            let index = 0; 

            paths.forEach(function(path)
            {        
                let img = new Picture(0, 0, 100, 100, path, category);
                img.setDominantColor(dominantColors[index]);
                index++;

                let eventname = "processed_picture_" + img.impath;
                let eventP = new Event(eventname);

                
                document.addEventListener(eventname, function(){
                    self.imageProcessed(img, eventname);
                },false);

                img.computation(cnv, h12color, colmoments, eventP);
            });

        });
    }

    //When the event "processed_picture_" is enabled this method is called to check if all the images are
    //already processed. When all the images are processed, a database organized in XML is saved in the localStorage
    //to answer the queries related to Color and Image Example
    imageProcessed (img, eventname) {
        this.allpictures.insert(img);
        console.log("image processed " + this.allpictures.stuff.length + eventname);
        if (this.allpictures.stuff.length === (this.num_Images * this.categories.length)) {
            this.createXMLColordatabaseLS();
            //this.createXMLIExampledatabaseLS();
        }
    }

    //Method to create the XML database in the localStorage for color queries
    createXMLColordatabaseLS() {
        let self = this;

        this.categories.forEach(function(category)
        {
            let xml = '<images>';

            let images = self.allpictures.stuff.filter(imageCategory => category === imageCategory.category);
        
            let index = 0;
            self.colors.forEach(function(color)
            {
                let colorIndex;

                for(let index = 0; index < self.colors.length; index++)
                {
                    if(self.colors[index] === color)
                    {
                        colorIndex = index;
                        break;
                    }
                }
        
                let colorRGB = [self.redColor[colorIndex], self.greenColor[colorIndex], self.blueColor[colorIndex]];            

                images.forEach(function(image)
                {
                    let hex = image.getDominantColor();
                    let hexToRgb = self.getRGBfromHEX(hex);
                
                    image.manhattanDist.push(self.calcManhattanDist(hexToRgb, colorRGB));
                });

                
                //console.log(hex + " | " + hexToRgb);
                self.sortbyManhattanDist(index, images);
                console.log(images);
                for(let i = 0; i < self.numshownpic; i++)
                {
                    xml += '<image class="' + color + '">';
                    
                    xml += '<path>' + images[i].impath + '</path>';

                    xml += '</image>';
                }                    
                index++;
            });

            xml += '</images>';

            self.LS_db.saveLS_XML(category, xml);
        });
    }

    getRGBfromHEX(hex)
    {
        let result = /^#?([a-f\d]{2})([a-f\d]{2})([a-f\d]{2})$/i.exec(hex);
        
        return result ? [parseInt(result[1], 16), parseInt(result[2], 16), parseInt(result[3], 16)] : null;
    }

    //Method to create the XML database in the localStorage for Image Example queries
    createXMLIExampledatabaseLS() {
        let list_images = new Pool(this.allpictures.stuff.length);
        this.zscoreNormalization();


        // this method should be completed by the students

    }

    //A good normalization of the data is very important to look for similar images. This method applies the
    // zscore normalization to the data
    zscoreNormalization() {
        let overall_mean = [];
        let overall_std = [];

        // Inicialization
        for (let i = 0; i < this.allpictures.stuff[0].color_moments.length; i++) {
            overall_mean.push(0);
            overall_std.push(0);
        }

        // Mean computation I
        for (let i = 0; i < this.allpictures.stuff.length; i++) {
            for (let j = 0; j < this.allpictures.stuff[0].color_moments.length; j++) {
                overall_mean[j] += this.allpictures.stuff[i].color_moments[j];
            }
        }

        // Mean computation II
        for (let i = 0; i < this.allpictures.stuff[0].color_moments.length; i++) {
            overall_mean[i] /= this.allpictures.stuff.length;
        }

        // STD computation I
        for (let i = 0; i < this.allpictures.stuff.length; i++) {
            for (let j = 0; j < this.allpictures.stuff[0].color_moments.length; j++) {
                overall_std[j] += Math.pow((this.allpictures.stuff[i].color_moments[j] - overall_mean[j]), 2);
            }
        }

        // STD computation II
        for (let i = 0; i < this.allpictures.stuff[0].color_moments.length; i++) {
            overall_std[i] = Math.sqrt(overall_std[i]/this.allpictures.stuff.length);
        }

        // zscore normalization
        for (let i = 0; i < this.allpictures.stuff.length; i++) {
            for (let j = 0; j < this.allpictures.stuff[0].color_moments.length; j++) {
                this.allpictures.stuff[i].color_moments[j] = (this.allpictures.stuff[i].color_moments[j] - overall_mean[j]) / overall_std[j];
            }
        }
    }

    //Method to search images based on a selected color
    searchColor(category, color, canvas) {
        let newXML = this.LS_db.readLS_XML(category);
        this.XML_db.setXML(newXML);
        let paths = this.XML_db.SearchXMLByKeyword(color, this.numshownpic);
        //console.log(this.XML_db.xml);
        this.allpictures.empty_Pool();
        //console.log(paths.length); //LS ou SearchByKeyword
        for(let i = 0; i < paths.length; i++)
        {
            this.allpictures.insert(new Picture(0, 0, this.imgWidth, this.imgHeight, paths[i], category));
        }

        //console.log(this.allpictures.stuff);

        this.gridView(canvas);
    }

    //Method to search images based on keywords
    searchKeywords(category, canvas) {
        let newXML = this.XML_db.loadXMLfile(this.XML_file);
        this.XML_db.setXML(newXML);
        //console.log(this.XML_file);
        
        console.log("1º");
        console.log(this.XML_db.xml);
        let paths = this.XML_db.SearchXMLByKeyword(category, this.numshownpic);

        this.allpictures.empty_Pool();

        for(let i = 0; i < paths.length; i++)
        {
            this.allpictures.insert(new Picture(0, 0, this.imgWidth, this.imgHeight, paths[i], category));
        }

        this.gridView(canvas);
    }

    //Method to search images based on Image similarities
    searchISimilarity(IExample, dist) {

        // this method should be completed by the students

    }

    //Method to compute the Manhattan difference between 2 images which is one way of measure the similarity
    //between images.
    calcManhattanDist(color1, color2){
        let manhattan = 0;

        for(let i=0; i < color1.length; i++){
            manhattan += Math.abs(color1[i] - color2[i]) + Math.abs(color1[i] - color2[i]) + Math.abs(color1[i] - color2[i]);
        }

        manhattan /= color1.length;
        
        return manhattan;
    }

    //Method to sort images according to the Manhattan distance measure
    sortbyManhattanDist(idxdist,list){
        list.sort(function (a, b) {
            return a.manhattanDist[idxdist] - b.manhattanDist[idxdist];
        });
    }

    //Method to sort images according to the number of pixels of a selected color
    sortbyColor (idxColor, list) {
        list.sort(function (a, b) {
            return b.hist[idxColor] - a.hist[idxColor];
        });
    }

    //Method to visualize images in canvas organized in columns and rows
    gridView (canvas) {
        let index = 0;

        for(let i = 0; i < 5; i++)
        {
            for(let j = 0; j < 7; j++)
            {
                this.allpictures.stuff[index].setPosition(i * (canvas.width / 5), j * (canvas.height / 7));
                this.allpictures.stuff[index].draw(canvas);
                index++;
            }
        }
    }
}


class Pool {
    constructor (maxSize) {
        this.size = maxSize;
        this.stuff = [];

    }

    insert (obj) {
        if (this.stuff.length < this.size) {
            this.stuff.push(obj);
        } else {
            alert("The application is full: there isn't more memory space to include objects");
        }
    }

    remove () {
        if (this.stuff.length !== 0) {
            this.stuff.pop();
        } else {
           alert("There aren't objects in the application to delete");
        }
    }

    empty_Pool () {
        while (this.stuff.length > 0) {
            this.remove();
        }
    }
}