class DrawingObjects
{
    constructor (px, py, name) {
        if (this.constructor === DrawingObjects) {
            // Error Type 1. Abstract class can not be constructed.
            throw new TypeError("Can not construct abstract class.");
        }

        //else (called from child)
        // Check if all instance methods are implemented.
        if (this.draw === DrawingObjects.prototype.draw) {
            // Error Type 4. Child has not implemented this abstract method.
            throw new TypeError("Please implement abstract method draw.");
        }

        if (this.mouseOver === DrawingObjects.prototype.mouseOver) {
            // Error Type 4. Child has not implemented this abstract method.
            throw new TypeError("Please implement abstract method mouseOver.");
        }

        this.posx = px;
        this.posy = py;
        this.name = name;
    }

    draw (cnv) {
        // Error Type 6. The child has implemented this method but also called `super.foo()`.
        throw new TypeError("Do not call abstract method draw from child.");
    }

    mouseOver(mx, my) {
        // Error Type 6. The child has implemented this method but also called `super.foo()`.
        throw new TypeError("Do not call abstract method mouseOver from child.");
    }


    sqDist(px1, py1, px2, py2) {
        let xd = px1 - px2;
        let yd = py1 - py2;

        return ((xd * xd) + (yd * yd));
    }

    setPos(x, y) {
        this.posx = x;
        this.posy = y;
    }
}

class Rect extends DrawingObjects
{

    constructor (px, py, w, h, c) {
        super(px, py, 'R');
        this.w = w;
        this.h = h;
        this.color = c;
    }

    draw (cnv) {
        let ctx = cnv.getContext("2d");

        ctx.fillStyle = this.color;
        ctx.fillRect(this.posx, this.posy, this.w, this.h);

    }

    mouseOver(mx, my) {
        return ((mx >= this.posx) && (mx <= (this.posx + this.w)) && (my >= this.posy) && (my <= (this.posy + this.h)));
    }
}

class Picture extends DrawingObjects
{

    constructor (px, py, w, h, impath) {
        super(px, py, 'P');
        this.w = w;
        this.h = h;
        this.impath = impath;
        this.imgobj = new Image();
        this.imgobj.src = this.impath;
    }

    draw (cnv) {
        let ctx = cnv.getContext("2d");

        if (this.imgobj.complete) {
            ctx.drawImage(this.imgobj, this.posx, this.posy, this.w, this.h);
            console.log("Debug: N Time");

        } else {
            console.log("Debug: First Time");
            let self = this;
            this.imgobj.addEventListener('load', function () {
                ctx.drawImage(self.imgobj, self.posx, self.posy, self.w, self.h);
            }, false);
        }
    }

    mouseOver(mx, my) {
        return ((mx >= this.posx) && (mx <= (this.posx + this.w)) && (my >= this.posy) && (my <= (this.posy + this.h)));
    }
}

class Oval extends DrawingObjects
{
    constructor (px, py, r, hs, vs, c) {
        super(px, py, 'O');
        this.r = r;
        this.radsq = r * r;
        this.hor = hs;
        this.ver = vs;
        this.color = c;
    }

    mouseOver (mx, my) {
        let x1 = 0;
        let y1 = 0;
        let x2 = (mx - this.posx) / this.hor;
        let y2 = (my - this.posy) / this.ver;

        return (this.sqDist(x1,y1,x2,y2) <= (this.radsq));
    }

    draw (cnv) {
        let ctx = cnv.getContext("2d");

        ctx.save();
        ctx.translate(this.posx,this.posy);
        ctx.scale(this.hor,this.ver);
        ctx.fillStyle = this.color;
        ctx.beginPath();
        ctx.arc(0, 0, this.r, 0, 2*Math.PI, true);
        ctx.closePath();
        ctx.fill();
        ctx.restore();
    }
}


class Heart extends DrawingObjects
{
    constructor (px, py, w, c) {
        super(px, py, 'H');
        this.h = w * 0.7;
        this.drx = w / 4;
        this.radsq = this.drx * this.drx;
        this.ang = .25 * Math.PI;
        this.color = c;
    }

    outside (x, y, w, h, mx, my) {
        return ((mx < x) || (mx > (x + w)) || (my < y) || (my > (y + h)));
    }

    draw (cnv) {
        let leftctrx = this.posx - this.drx;
        let rightctrx = this.posx + this.drx;
        let cx = rightctrx + this.drx * Math.cos(this.ang);
        let cy = this.posy + this.drx * Math.sin(this.ang);
        let ctx = cnv.getContext("2d");

        ctx.fillStyle = this.color;
        ctx.beginPath();
        ctx.moveTo(this.posx, this.posy);
        ctx.arc(leftctrx, this.posy, this.drx, 0, Math.PI - this.ang, true);
        ctx.lineTo(this.posx, this.posy + this.h);
        ctx.lineTo(cx,cy);
        ctx.arc(rightctrx, this.posy, this.drx, this.ang, Math.PI, true);
        ctx.closePath();
        ctx.fill();
    }

    mouseOver (mx, my) {
        let leftctrx = this.posx - this.drx;
        let rightctrx = this.posx + this.drx;
        let qx = this.posx - 2 * this.drx;
        let qy = this.posy - this.drx;
        let qwidth = 4 * this.drx;
        let qheight = this.drx + this.h;

        let x2 = this.posx;
        let y2 = this.posy + this.h;
        let m = (this.h) / (2 * this.drx);

        //quick test if it is in bounding rectangle
        if (this.outside(qx, qy, qwidth, qheight, mx, my)) {
            return false;
        }

        //compare to two centers
        if (this.sqDist (mx, my, leftctrx, this.posy) < this.radsq) return true;
        if (this.sqDist(mx, my, rightctrx, this.posy) < this.radsq) return true;

        // if outside of circles AND less than equal to y, return false
        if (my <= this.posy) return false;

        // compare to each slope
        // left side
        if (mx <= this.posx) {
            return (my < (m * (mx - x2) + y2));
        } else {  //right side
            m = -m;
            return (my < (m * (mx - x2) + y2));
        }
    }
}

class Bear extends DrawingObjects
{
    constructor (px, py, r, hs, vs, cMain, cSecondary) {
        super(px, py, 'B');
        this.r = r;
        this.hs = hs;
        this.vs = vs;
        this.colorMain = cMain;
        this.colorSecondary = cSecondary;

        this.bearLeftEar = new Oval(px - 3*r/4, py - 5*r/8, 3*r/4, hs, vs, cMain);
        this.bearInsideLeftEar = new Oval(px - 3*r/4, py - 5*r/8, 5*r/11, hs, vs, cSecondary);
        this.bearRightEar = new Oval(px + 3*r/4, py - 5*r/8, 3*r/4, hs, vs, cMain);
        this.bearInsideRightEar = new Oval(px + 3*r/4, py - 5*r/8, 5*r/11, hs, vs, cSecondary);
        this.bearHead = new Oval(px, py, r, hs, vs, cMain);
        this.bearLeftEye = new Oval(px - 3*r/7, py - r/6, r/7, hs, vs, cSecondary);
        this.bearLeftEyeShine = new Oval(px - 3*r/7 - r/(7*2), py - r/6 - r/(7*2), r/(7*2), hs, vs, cMain);
        this.bearRightEye = new Oval(px + 3*r/7, py - r/6, r/7, hs, vs, cSecondary);
        this.bearRightEyeShine = new Oval(px + 3*r/7 - r/(7*2), py - r/6 - r/(7*2), r/(7*2), hs, vs, cMain);
        this.bearNose = new Oval(px, py + r/4, r/4, hs + (hs/3), vs, cSecondary);
        this.bearNoseShine = new Oval(px - r/5, py + r/6, r/(6*2), hs, vs, cMain);
    }

    mouseOver (mx, my) {
        
        return (this.bearLeftEar.mouseOver(mx, my) || this.bearRightEar.mouseOver(mx, my) || this.bearHead.mouseOver(mx, my))
    }

    draw (cnv) {
        let ctx = cnv.getContext("2d");

        this.bearLeftEar.draw(cnv);
        this.bearInsideLeftEar.draw(cnv);
        this.bearRightEar.draw(cnv);
        this.bearInsideRightEar.draw(cnv);
        this.bearHead.draw(cnv);
        this.bearLeftEye.draw(cnv);
        this.bearLeftEyeShine.draw(cnv);
        this.bearRightEye.draw(cnv);
        this.bearRightEyeShine.draw(cnv);
        this.bearNose.draw(cnv);
        this.bearNoseShine.draw(cnv);

        //Boca
        ctx.save()
        
        ctx.beginPath();
        ctx.strokeStyle = this.colorSecondary;
        ctx.moveTo(this.posx - this.r / 4, this.posy + this.r / 2);
        ctx.arc(this.posx - this.r / 8, this.posy + this.r / 2, this.r / 8, Math.PI, 2 * Math.PI, true);
        ctx.arc(this.posx + this.r / 8, this.posy + this.r / 2, this.r / 8, Math.PI, 2 * Math.PI, true); 
        ctx.moveTo(this.posx, this.posy + this.r / 2);
        ctx.closePath();

        ctx.stroke();
        ctx.restore();
    }
    
    setPos(x, y) {
        super.setPos(x, y);

        this.bearLeftEar.setPos(x - 3*this.r/4, y - 5*this.r/8);
        this.bearInsideLeftEar.setPos(x - 3*this.r/4, y - 5*this.r/8);
        this.bearRightEar.setPos(x + 3*this.r/4, y - 5*this.r/8);
        this.bearInsideRightEar.setPos(x + 3*this.r/4, y - 5*this.r/8);
        this.bearHead.setPos(x, y);
        this.bearLeftEye.setPos(x - 3*this.r/7, y - this.r/6);
        this.bearLeftEyeShine.setPos(x - 3*this.r/7 - this.r/(7*2), y - this.r/6 - this.r/(7*2));
        this.bearRightEye.setPos(x + 3*this.r/7, y - this.r/6);
        this.bearRightEyeShine.setPos(x + 3*this.r/7 - this.r/(7*2), y - this.r/6 - this.r/(7*2));
        this.bearNose.setPos(x, y + this.r/4);
        this.bearNoseShine.setPos(x - this.r/5, y + this.r/6);
    }
}

class Ghost extends DrawingObjects
{
    constructor (px, py, width, height, cBody, cEyes) {
        super(px, py, 'G');
        this.width = width;
        this.height = height;
        this.color = cBody;
        this.colorEyes = cEyes;

        this.leftEye = new Oval(px - (width / 4), py - (height / 6), width / 8, 1, 1, this.colorEyes);
        this.leftPupil = new Oval(px - (3 * width / 10), py - (height / 8), width / 16, 1, 1, this.color);
        this.rightEye = new Oval(px + (width / 4), py - (height / 6), width / 8, 1, 1, this.colorEyes);
        this.rightPupil = new Oval(px + (width / 5), py - (height / 8), width / 16, 1, 1, this.color);
    }

    mouseOver (mx, my) {
        return ((mx > this.posx - (this.width / 2)) && (mx <  this.posx + (this.width / 2)) && (my > this.posy - (this.height / 2)) && (my < this.posy + (this.height / 2)));
    }

    draw (cnv) {
        let ctx = cnv.getContext("2d");

        ctx.save();
        ctx.fillStyle = this.color;
        ctx.lineWidth = 5;

        ctx.beginPath();
        ctx.moveTo(this.posx - (this.width / 2) + (this.width / 4), this.posy - (this.height / 2));
        ctx.lineTo(this.posx + (this.width / 2) - (this.width / 4), this.posy - (this.height / 2));
        ctx.quadraticCurveTo(this.posx + (this.width / 2), this.posy - (this.height / 2), this.posx + (this.width / 2), this.posy - (this.height / 2) + (this.width / 4));
        ctx.lineTo(this.posx + (this.width / 2), this.posy + (this.height / 2)); //1º bico (a contar da direita)
        ctx.lineTo(this.posx + (this.width / 2) - (this.width / 10), this.posy + (this.height / 2) - (this.height / 3)); //2º bico
        ctx.lineTo(this.posx + (this.width / 2) - ((3 * this.width) / 10), this.posy + (this.height / 2)); //3º bico
        ctx.lineTo(this.posx, this.posy + (this.height / 2) - (this.height / 3)); //4º bico
        ctx.lineTo(this.posx - (this.width / 2) + ((3 * this.width) / 10), this.posy + (this.height / 2)); //5º bico
        ctx.lineTo(this.posx - (this.width / 2) + (this.width / 10), this.posy + (this.height / 2) - (this.height / 3)); //6º bico
        ctx.lineTo(this.posx - (this.width / 2), this.posy + (this.height / 2));
        ctx.lineTo(this.posx - (this.width / 2), this.posy - (this.height / 2) + (this.width / 4));
        ctx.quadraticCurveTo(this.posx - (this.width / 2), this.posy - (this.height / 2), this.posx - (this.width / 2) + (this.width / 4), this.posy - (this.height / 2));
        
        ctx.closePath();
        ctx.fill();
        ctx.restore();

        this.leftEye.draw(cnv);
        this.leftPupil.draw(cnv);
        this.rightEye.draw(cnv);
        this.rightPupil.draw(cnv);
    }

    setPos(x, y) {
        super.setPos(x, y);

        this.leftEye.setPos(x - (this.width / 4), y - (this.height / 6), this.width / 8, 1, 1, this.colorEyes);
        this.leftPupil.setPos(x - (3 * this.width / 10), y - (this.height / 8), this.width / 16, 1, 1, this.color);
        this.rightEye.setPos(x + (this.width / 4), y - (this.height / 6), this.width / 8, 1, 1, this.colorEyes);
        this.rightPupil.setPos(x + (this.width / 5), y - (this.height / 8), this.width / 16, 1, 1, this.color);
    }
}

class Smile extends DrawingObjects 
{
    constructor (px, py, radius, cBody, cSecondary) {
        super(px, py, 'S');
        this.radius = radius;
        this.color = cBody;
        this.colorSecondary = cSecondary;

        this.body = new Oval(px, py, this.radius, 1, 1, this.color);
    }

    mouseOver (mx, my) {
        return this.body.mouseOver(mx, my);
    }

    draw (cnv) {
        let ctx = cnv.getContext("2d");

        this.body.draw(cnv);

        //Left Eye
        ctx.save();
        ctx.strokeStyle = this.colorSecondary;
        ctx.beginPath();
        
        ctx.translate(this.posx - (this.radius / 2), this.posy - (this.radius / 4));
        ctx.rotate(45 * Math.PI / 180);
        ctx.translate(-(this.posx - (this.radius / 2)), -(this.posy - (this.radius / 4)));
        
        ctx.moveTo(this.posx - ((3 * this.radius) / 4), this.posy - (this.radius / 4));
        ctx.lineTo(this.posx - (this.radius / 4), this.posy - (this.radius / 4));

        ctx.moveTo(this.posx - (this.radius / 2), this.posy - (this.radius / 2));
        ctx.lineTo(this.posx - (this.radius / 2), this.posy);

        ctx.stroke();
        ctx.restore();

        //Right Eye
        ctx.save();
        ctx.strokeStyle = this.colorSecondary;
        ctx.beginPath();

        ctx.translate(this.posx + (this.radius / 2), this.posy - (this.radius / 4));
        ctx.rotate(45 * Math.PI / 180);
        ctx.translate(-(this.posx + (this.radius / 2)), -(this.posy - (this.radius / 4)));
        
        ctx.moveTo(this.posx + ((3 * this.radius) / 4), this.posy - (this.radius / 4));
        ctx.lineTo(this.posx + (this.radius / 4), this.posy - (this.radius / 4));

        ctx.moveTo(this.posx + (this.radius / 2), this.posy - (this.radius / 2));
        ctx.lineTo(this.posx + (this.radius / 2), this.posy);

        ctx.stroke();
        ctx.restore();

        //Mouth
        ctx.save();
        ctx.fillStyle = this.colorSecondary;
        ctx.beginPath();

        ctx.moveTo(this.posx - (this.radius / 2), this.posy + (this.radius / 4));
        ctx.arc(this.posx, this.posy + (this.radius / 4), this.radius / 2, Math.PI, 2 * Math.PI, true);
        
        ctx.closePath();
        ctx.fill();
        ctx.restore();
    }

    setPos(x, y) {
        super.setPos(x, y);

        this.body.setPos(x, y, this.radius, 1, 1, this.color);
    }
}

class Text extends DrawingObjects 
{
    constructor (px, py, text, textHeight, textWidth, color) {
        super(px, py, 'T');
        this.text = text;
        this.textHeight = textHeight;
        this.textWidth = textWidth;
        this.color = color;

        this.boundingBox = new Rect(px, py, textWidth, textHeight, "black");
    }

    mouseOver (mx, my) {
        return this.boundingBox.mouseOver(mx, my);
    }

    draw (cnv) {
        let ctx = cnv.getContext("2d");

        ctx.font = this.textHeight + "px Arial";
        console.log(ctx.font);
        ctx.fillStyle = this.color;
        ctx.fillText(this.text, this.px, this.py);

        //this.boundingBox.draw(cnv);
    }

    setPos(x, y) {
        this.boundingBox.setPos(x, y, this.width, this.radius, this.color);
    }
}