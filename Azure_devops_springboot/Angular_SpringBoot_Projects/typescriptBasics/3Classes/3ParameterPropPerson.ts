class Person2{
  constructor(private _firstName:string,private _secondName:string){

  }// no need to write variable
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
 let person2=new Person2("Rahul","Kumar");
 console.log(person2.firstName)
 console.log(person2.secondName)
