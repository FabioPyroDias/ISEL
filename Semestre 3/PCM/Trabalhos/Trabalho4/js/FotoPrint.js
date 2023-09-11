'use strict';

class FotoPrint
{
    constructor() {
        this.thingInMotion = null;
        this.offsetx = null;
        this.offsety = null;
        this.shpinDrawing = new Pool(100);
        this.shpinSelector = new Pool(6);

        this.color = "black";
        this.backgroundColor = "white";
    }

    init() {
        /*
        let r = new Rect(100, 100, 20, 20, this.color);
        this.shpinDrawing.insert(r);

        let o = new Oval(150, 150, 50, 1, 1, this.color);
        this.shpinDrawing.insert(o);

        let h = new Heart(250, 250, 80, this.color);
        this.shpinDrawing.insert(h);

        let dad = new Picture(200, 200, 70, 70, "imgs/allison1.jpg");
        this.shpinDrawing.insert(dad);

        let bear = new Bear(400, 300, 50, 1, 1, this.color, this.backgroundColor);
        this.shpinDrawing.insert(bear);

        let ghost = new Ghost(400, 100, 100, 80, this.color, this.backgroundColor);
        this.shpinDrawing.insert(ghost);
        
        let smile = new Smile(500, 300, 50, this.color, this.backgroundColor);
        this.shpinDrawing.insert(smile);
        */
    }

    drawObj(cnv) {
        for (let i = 0; i < this.shpinDrawing.stuff.length; i++) {
            this.shpinDrawing.stuff[i].draw(cnv);
        }
    }

    dragObj(mx, my) {
        let endpt = this.shpinDrawing.stuff.length-1;

        for (let i = endpt; i >= 0; i--) {
            if (this.shpinDrawing.stuff[i].mouseOver(mx, my)) {
                this.offsetx = mx - this.shpinDrawing.stuff[i].posx;
                this.offsety = my - this.shpinDrawing.stuff[i].posy;
                let item = this.shpinDrawing.stuff[i];
                this.thingInMotion = this.shpinDrawing.stuff.length - 1;
                this.shpinDrawing.stuff.splice(i, 1);
                this.shpinDrawing.stuff.push(item);
                return true;
            }
        }
        return false;
    }

    moveObj(mx, my) {
        /*
        this.shpinDrawing.stuff[this.thingInMotion].posx = mx - this.offsetx;
        this.shpinDrawing.stuff[this.thingInMotion].posy = my - this.offsety;
        */
        
        this.shpinDrawing.stuff[this.thingInMotion].setPos(mx, my);
    }

    removeObj () {
        this.shpinDrawing.remove();
    }

    insertObj (mx, my, itemToBePlaced) {
        let item = null;
        let endpt = this.shpinDrawing.stuff.length-1;

        for (let i = endpt; i >= 0; i--) {
            if (this.shpinDrawing.stuff[i].mouseOver(mx,my)) {
                item = this.cloneObj(this.shpinDrawing.stuff[i]);
                this.shpinDrawing.insert(item);
                return;
            }
        }

        if(itemToBePlaced != null)
        {
            this.shpinDrawing.insert(itemToBePlaced);
        }
    }

    cloneObj (obj) {
        let item = {};

        switch(obj.name) {
            case "R":
                item = new Rect(obj.posx + 20, obj.posy + 20, obj.w, obj.h, obj.color);
                break;

            case "P":
                item = new Picture(obj.posx + 20, obj.posy + 20, obj.w, obj.h, obj.impath);
                break;

            case "O":
                item = new Oval(obj.posx + 20, obj.posy + 20, obj.r, obj.hor, obj.ver, obj.color);
                break;

            case "H":
                item = new Heart(obj.posx + 20, obj.posy + 20, obj.drx * 4, obj.color);
                break;

            case "B":
                item  = new Bear(obj.posx + 20, obj.posy +20, obj.r, obj.hor, obj.ver, obj.colorMain, obj.colorSecondary);
                break;

            case "G":
                item  = new Ghost(obj.posx + 20, obj.posy +20, obj.width, obj.height, obj.color, obj.colorEyes);
                break;

            case "S":
                item = new Smile(obj.posx + 20, obj.posy + 20, obj.radius, obj.color, obj.colorSecondary);
                break;

            case "T":
                item = new Text(obj.posx + 20, obj.posy + 20, obj.text, obj.textHeight, obj.textWidth, obj.color);
                break;

            default: throw new TypeError("Can not clone this type of object");
        }
        return item;
    }

    selectObj (mx, my)
    {
        let endpt = this.shpinSelector.stuff.length-1;

        for (let i = endpt; i >= 0; i--) {
            if (this.shpinSelector.stuff[i].mouseOver(mx,my)) {
                return this.cloneObj(this.shpinSelector.stuff[i]);
            }
        }

        return null;
    }

    drawObjsel(cpo)
    {
        for (let i = 0; i < this.shpinSelector.stuff.length; i++) {
            this.shpinSelector.stuff[i].draw(cpo);
        }
    }

    initialization()
    { //MUDAR OS X'S DE CADA OBJECTO PARA SER DISTRIBUIDO CORRECTAMENTE
        let r = new Rect(50, 40, 70, 70, this.color);
        this.shpinSelector.insert(r);

        let o = new Oval(250, 75, 35, 1, 1, this.color);
        this.shpinSelector.insert(o);

        let h = new Heart(400, 55, 75, this.color);
        this.shpinSelector.insert(h);

        let bear = new Bear(575, 80, 35, 1, 1, this.color, this.backgroundColor);
        this.shpinSelector.insert(bear);

        let ghost = new Ghost(750, 80, 90, 75, this.color, this.backgroundColor);
        this.shpinSelector.insert(ghost);
        
        let smile = new Smile(940, 75, 40, this.color, this.backgroundColor);
        this.shpinSelector.insert(smile);
    }

    setColor(newColor)
    {
        this.color = newColor;

        while(this.shpinSelector.stuff.length > 0)
        {
            this.shpinSelector.remove();
        }

        this.initialization();
    }

    setBackgroundColor(newColor)
    {
        this.backgroundColor = newColor;

        while(this.shpinSelector.stuff.length > 0)
        {
            this.shpinSelector.remove();
        }

        this.initialization();
    }

    addText(text, textWidth)
    {
        console.log("IS CALLED");
        let textItem = new Text(100, 100, text, 80, textWidth, this.color);
        console.log(textItem);
        this.shpinDrawing.insert(textItem);
    }

    addPicture(path)
    {
        let picture = new Picture(100, 100, 50, 50, path);
        this.shpinDrawing.insert(picture);

        console.log(this.shpinDrawing.stuff);
    }
}


class Pool
{
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
}

