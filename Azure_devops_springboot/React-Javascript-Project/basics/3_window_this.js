
var a=10;

function fn(){
    var x=10;
}

console.log(this.a)
console.log(window.a)
// window and this will access global object or variable .ie basically outside the function