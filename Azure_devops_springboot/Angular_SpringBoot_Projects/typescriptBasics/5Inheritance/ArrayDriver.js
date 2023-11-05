"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var Rectangle_1 = require("./Rectangle");
var circle_1 = require("./circle");
var myCircle = new circle_1.Circle(5, 20, 30);
console.log(myCircle.getInfo());
var myRectangle = new Rectangle_1.Rectangle(1, 4, 5, 50);
console.log(myRectangle.getInfo());
var shapes = [];
// add shapes to it
shapes.push(myCircle);
shapes.push(myRectangle);
console.log("All shapes");
for (var _i = 0, shapes_1 = shapes; _i < shapes_1.length; _i++) {
    var tempShape = shapes_1[_i];
    console.log(tempShape.getInfo());
    console.log(tempShape.getArear());
}
