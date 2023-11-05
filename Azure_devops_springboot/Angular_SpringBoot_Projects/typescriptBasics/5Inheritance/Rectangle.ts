import { Shape } from "./Shape";

export class Rectangle extends Shape{
    getArear(): number {
        return this._l* this._w;
    }

    constructor( private _thex: number,private _they: number,private _w: number, private _l: number){
        super(_thex,_they);
    }
    public get w(): number {
        return this._w;
    }
    public set w(value: number) {
        this._w = value;
    }
   
    public get l(): number {
        return this._l;
    }
public set l(value: number) {
        this._l = value;
    }
  getInfo(): string {
      return `Rectangle ${this._w} ${this._l}  `+ super.getInfo()
  }
}