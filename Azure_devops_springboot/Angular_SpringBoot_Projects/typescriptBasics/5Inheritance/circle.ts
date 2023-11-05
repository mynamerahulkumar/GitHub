import { Shape } from "./Shape";

export class Circle extends Shape{
    getArear(): number {
        return Math.PI*Math.pow(this._r,2);
    }

    constructor(private theX:number,private theY:number,private _r:number){
            super(theX,theY);
    }
    get rValue():number{
        return this._r;
    }
    
    set rValue(r:number){
        this._r=r;
    }
    getInfo(): string {
        return `Circle `+super.getInfo()+`${this._r}`
    }
}