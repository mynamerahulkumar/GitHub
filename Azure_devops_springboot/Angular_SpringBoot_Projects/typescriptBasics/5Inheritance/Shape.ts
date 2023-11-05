export abstract class Shape{
    constructor(private _x:number,private _y:number){

    }
    get xValue():number{
        return this._x;
    }

    set xValue(x:number){
        this._x=x;
    }
    get yValue():number{
        return this._y;
    }

    set yValue(y:number){
        this._y=y;
    }
    getInfo():string{
        return `Hi ${this._x} ${this._y}`
    }
    abstract getArear():number;
    
}