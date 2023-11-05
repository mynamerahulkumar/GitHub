class Person1{
    private _firstName:string;// just a convention to use _ we can use any other thing
    private _secondName:string;
    
    public get firstName():string{
       return this._firstName;
    }
    public set firstName(first:string){
        this._firstName=first;
    }
    public get secondName():string{
        return this._secondName;
     }
     public set secondName(second:string){
         this._secondName=second;
     }
     
    constructor(first:string,Second:string){
        this._firstName=first;
        this._secondName=Second;
    }


}
//let create an instance
let person1 =new Person1("Rahul","Kumar");
//console.log(person1._firstName)// can't access private field
console.log(person1.firstName)// can't access private field
console.log(person1.secondName)// can't access private field
