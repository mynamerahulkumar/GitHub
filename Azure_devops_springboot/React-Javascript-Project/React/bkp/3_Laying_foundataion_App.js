import React from "react";
import ReactDOM from "react-dom/client";

//React Element

// const heading=React.createElement("h1",{id:"heading"},
//   "Namaste React ") // created a react object

 const root=ReactDOM.createRoot(document.getElementById("root"));// replaced the root element

// //root.render(heading);

// console.log(heading);

// JSX is diffe from React- jsx is different syntax but this is not html 
// jSX code is transpiled before it reached by JS engine by parcel-Babel


//JSX=>React.createElement =>ReactElement JS object=>HTMLElement(render)
//() for multiple lines 
const jsxHeading=(<h1 className="head"> Namaste React using JSX ✈️</h1>); // jsxheading is react element

console.log(jsxHeading);

//root.render(jsxHeading);

// React component
//1. Class based component-OLD
//2. Functional based component- NEW

//React Functional component-Normal JS function-which return some React element(JSX element)

const HeadingComponent=()=>{
    return <h1>Namaste React Functional Component </h1>;
}
const elem=<span>React Element</span>
const Title=()=>(
    <h1 className="head" tabIndex="5"> 
    {elem}
    Namaste React using JSX ✈️</h1>
)
const number=10000;
// component compisition
// {} any pice of js code
const HeadingComponent2=()=>(
    <div id="container">
       <h2>{number+number}</h2> 
        <Title/> 
        <h1 className="heading">Namaster React Functional Component</h1>
    </div>
);
const HeadingComponent3=()=>(
    <div id="container">
       <h2>{number+number}</h2> 
        {Title()}
        <Title></Title>
        <h1 className="heading">Namaster React Functional Component</h1>
    </div>
);
root.render(<HeadingComponent3/>);// functional component Babel understand

// JSX also removed malcious data from the API call 
// both are same functions 
const fn=()=>{
    return true;
}

const fn2=()=>true;






