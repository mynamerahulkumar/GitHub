import { Rectangle } from "./Rectangle";
import { Shape } from "./Shape";
import { Circle } from "./circle";


let myCircle=new Circle(5,20,30);
console.log(myCircle.getInfo())

let myRectangle=new Rectangle(1,4,5,50);
console.log(myRectangle.getInfo())

let shapes:Shape[]=[];
// add shapes to it
shapes.push(myCircle)
shapes.push(myRectangle)
console.log("All shapes")
for(let tempShape of shapes){
    console.log(tempShape.getInfo())
    console.log(tempShape.getArear())

}