'use strict';

let app = null;
let items = null;
let selectedItem = null;

let backgroundColor = "white";
let textInInput = null;

function main() {
    let cpo = document.getElementById('pickImage');
    let cnv = document.getElementById('canvas');

    let colorInput = document.getElementById('colorInput');

    drawCanvasRect(cpo);
    drawCanvasRect(cnv);

    app = new FotoPrint();
    app.init();
    app.drawObj(cnv);

    items = new FotoPrint();
    items.initialization();
    items.drawObjsel(cpo);

    cnv.addEventListener('mousedown', drag, false);
    cnv.addEventListener('dblclick', makenewitem, false);

    cpo.addEventListener('click', callback, false);

    colorInput.addEventListener('change', setColor, false);
}

function drawCanvasRect(cnv, newColor) {
    let ctx = cnv.getContext("2d");

    ctx.clearRect(0, 0, cnv.width, cnv.height);
    ctx.strokeStyle = "black";
    ctx.lineWidth = 2;
    
    if(newColor == null)
    {
        ctx.fillStyle = backgroundColor;
    }
    else
    {
        ctx.fillStyle = newColor;
    }
    
    ctx.fillRect(0, 0, cnv.width, cnv.height);
    ctx.strokeRect(0, 0, cnv.width, cnv.height);
}

//Drag & Drop operation
//drag
function drag(ev) {
    let mx = null;
    let my = null;
    let cnv = document.getElementById('canvas');

    let xPos = 0;
    let yPos = 0;
    [xPos, yPos] = getMouseCoord(cnv);
    mx = ev.x - xPos;
    my = ev.y - yPos;

    if (app.dragObj(mx, my)) {
        cnv.style.cursor = "pointer";
        cnv.addEventListener('mousemove', move, false);
        cnv.addEventListener('mouseup', drop, false);
    }

}

//Drag & Drop operation
//move
function move(ev) {
    let mx = null;
    let my = null;
    let cnv = document.getElementById('canvas');

    let xPos = 0;
    let yPos = 0;
    [xPos, yPos] = getMouseCoord(cnv);
    mx = ev.x - xPos;
    my = ev.y - yPos;

    app.moveObj(mx, my);
    drawCanvasRect(cnv);
    app.drawObj(cnv);
}

//Drag & Drop operation
//drop
function drop() {
    let cnv = document.getElementById('canvas');

    cnv.removeEventListener('mousemove', move, false);
    cnv.removeEventListener('mouseup', drop, false);
    cnv.style.cursor = "crosshair";
}

//Insert a new Object on Canvas
//dblclick Event
function makenewitem(ev) {
    let mx = null;
    let my = null;
    let cnv = document.getElementById('canvas');

    let xPos = 0;
    let yPos = 0;
    [xPos, yPos] = getMouseCoord(cnv);
    mx = ev.x - xPos;
    my = ev.y - yPos;

    app.insertObj(mx, my, selectedItem);    
    drawCanvasRect(cnv);
    app.drawObj(cnv);
}

//Delete button
//Onclick Event
function remove() {
    let cnv = document.getElementById('canvas');

    app.removeObj();
    drawCanvasRect(cnv);
    app.drawObj(cnv);
}

//Save button
//Onclick Event
function saveasimage() {
    try {
        window.open(document.getElementById('canvas').toDataURL("imgs/png"));}
    catch(err) {
        alert("You need to change browsers OR upload the file to a server.");
    }
}


//Mouse Coordinates for all browsers
function getMouseCoord(el) {
    let xPos = 0;
    let yPos = 0;

    while (el) {
        if (el.tagName === "BODY") {
            // deal with browser quirks with body/window/document and page scroll
            let xScroll = el.scrollLeft || document.documentElement.scrollLeft;
            let yScroll = el.scrollTop || document.documentElement.scrollTop;

            xPos += (el.offsetLeft - xScroll + el.clientLeft);
            yPos += (el.offsetTop - yScroll + el.clientTop);
        } else {
            // for all other non-BODY elements
            xPos += (el.offsetLeft - el.scrollLeft + el.clientLeft);
            yPos += (el.offsetTop - el.scrollTop + el.clientTop);
        }

        el = el.offsetParent;
    }
    return [xPos,yPos];
}

function callback(ev)
{
    let mx = null;
    let my = null;
    let cpo = document.getElementById('pickImage');

    let xPos = 0;
    let yPos = 0;
    [xPos, yPos] = getMouseCoord(cpo);
    mx = ev.x - xPos;
    my = ev.y - yPos;

    let temporaryItem = items.selectObj(mx, my);

    if (temporaryItem != null) {
        selectedItem = temporaryItem;
    }
}

function setColor()
{
    let cpo = document.getElementById('pickImage');
    let colorInput = document.getElementById('colorInput');

    items.setColor(colorInput.value);
    drawCanvasRect(cpo, "white");
    items.drawObjsel(cpo);
}

function setBackgroundColor()
{
    let cnv = document.getElementById('canvas');
    let cpo = document.getElementById('pickImage');
    let colorInput = document.getElementById('colorInput');

    backgroundColor = colorInput.value;
    drawCanvasRect(cnv);
    app.drawObj(cnv);

    items.setBackgroundColor(colorInput.value);
    drawCanvasRect(cpo, "white");
    items.drawObjsel(cpo);
}

function addText()
{
    let cnv = document.getElementById('canvas');
    let text = document.getElementById('textInput').value;

    console.log(text);

    if(text.length > 0)
    {
        app.addText(text, cnv.getContext("2d").measureText(text).width);
        drawCanvasRect(cnv);
        app.drawObj(cnv);
    }
}

function openImage()
{
    let cnv = document.getElementById('canvas');

    let fileInput = document.getElementById('fileInput');
    const fileUrl = window.URL.createObjectURL(fileInput.files[0]);
    
    app.addPicture(fileUrl);
    drawCanvasRect(cnv);
    app.drawObj(cnv);
}

function saveasimage() {
    try {
        let link = document.createElement('a');
        link.download = "imagecanvas.png";
        let canvas = document.getElementById("canvas");
        link.href = canvas.toDataURL("image/png").replace("image/png", "image/octet- stream");
        link.click();
    } catch (err) {
        alert("You need to change browsers OR upload the file to a server.");
    }
}