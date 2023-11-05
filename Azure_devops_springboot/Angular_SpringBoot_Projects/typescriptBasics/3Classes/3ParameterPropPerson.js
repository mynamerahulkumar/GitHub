var Person2 = /** @class */ (function () {
    function Person2(_firstName, _secondName) {
        this._firstName = _firstName;
        this._secondName = _secondName;
    }
    Object.defineProperty(Person2.prototype, "firstName", {
        get: function () {
            return this._firstName;
        },
        set: function (first) {
            this._firstName = first;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Person2.prototype, "secondName", {
        get: function () {
            return this._secondName;
        },
        set: function (second) {
            this._secondName = second;
        },
        enumerable: false,
        configurable: true
    });
    return Person2;
}());
var person2 = new Person2("Rahul", "Kumar");
console.log(person2.firstName);
console.log(person2.secondName);
