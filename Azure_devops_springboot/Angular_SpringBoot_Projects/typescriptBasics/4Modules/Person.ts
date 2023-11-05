export class Person4{
  constructor(private _firstName:string,private _secondName:string){

  }
  get firstName():string{
    return this._firstName;
  }
  set firstName(first:string){
    this._firstName=first;
  }
  get secondName():string{
    return this._secondName;
  }
  set secondName(second:string){
    this._secondName=second;
  }

}