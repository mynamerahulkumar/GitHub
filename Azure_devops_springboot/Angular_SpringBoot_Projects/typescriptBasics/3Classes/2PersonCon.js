var Person1 = /** @class */ (function () {
    function Person1(first, Second) {
        this._firstName = first;
        this._secondName = Second;
    }
    Object.defineProperty(Person1.prototype, "firstName", {
        get: function () {
            return this._firstName;
        },
        set: function (first) {
            this._firstName = first;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Person1.prototype, "secondName", {
        get: function () {
            return this._secondName;
        },
        set: function (second) {
            this._secondName = second;
        },
        enumerable: false,
        configurable: true
    });
    return Person1;
}());
//let create an instance
var person1 = new Person1("Rahul", "Kumar");
//console.log(person1._firstName)// can't access private field
console.log(person1.firstName); // can't access private field
console.log(person1.secondName); // can't access private field
