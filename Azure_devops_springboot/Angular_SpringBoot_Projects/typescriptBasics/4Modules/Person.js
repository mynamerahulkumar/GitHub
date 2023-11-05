"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Person4 = void 0;
var Person4 = /** @class */ (function () {
    function Person4(_firstName, _secondName) {
        this._firstName = _firstName;
        this._secondName = _secondName;
    }
    Object.defineProperty(Person4.prototype, "firstName", {
        get: function () {
            return this._firstName;
        },
        set: function (first) {
            this._firstName = first;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Person4.prototype, "secondName", {
        get: function () {
            return this._secondName;
        },
        set: function (second) {
            this._secondName = second;
        },
        enumerable: false,
        configurable: true
    });
    return Person4;
}());
exports.Person4 = Person4;
