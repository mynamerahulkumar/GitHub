const heading = React.createElement("h1", {
    id: "heading"
}, "Hello world from React!"); // tag,object,values// react first library
//attributes to ta get {}
// heading in js object or React element
console.log(heading) //object 
;
const root = ReactDOM.createRoot(document.getElementById("root")); // 2nd library
root.render(heading);
const parent = React.createElement("div", {
    id: "parent"
}, React.createElement("div", {
    id: "child"
}, React.createElement("h1", {}, "I am h1 tag")));
root.render(parent);
const parent1 = React.createElement("div", {
    id: "parent"
}, [
    React.createElement("div", {
        id: "child"
    }, [
        React.createElement("h1", {}, "I am h1 tag"),
        React.createElement("h2", {}, "I am h2 tag")
    ]),
    React.createElement("div", {
        id: "child2"
    }, [
        React.createElement("h1", {}, "I am h1 tag"),
        React.createElement("h2", {}, "I am h2 tag")
    ])
]);
// if h1 tag already present then it will replaced by the parent
//React is a library it can work inside one element eg header but it is not framework 
// order of files a matter a lot eg .app.js should be after script of cdn react
root.render(parent1);

//# sourceMappingURL=index2.6bd02f5a.js.map
