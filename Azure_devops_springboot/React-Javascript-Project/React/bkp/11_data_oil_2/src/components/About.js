import UserClass from "../FunComponents/UserClass";
import { User } from "../FunComponents/UserDetail";
import React from "react";
import { Component } from "react";

class About extends Component{

    constructor(props){
        super(props);
        console.log("About-cons")
    }
 componentDidMount(){
    /* cons,render,(child all thing mounted)  then this is called*/
    /* Very important use case,to call API,we want to render first ,make api call and fill the data(quick render will be done) */
    console.log("Parent-About-Comp-mount");
    // Api calls
 }
    render(){
        console.log("About-render")
        return (
            <div>
                <h1>About</h1>
                <h2>This is Namaste react web series</h2>
                {/* <User name={"Rahul Kumar(function)"}/> */}
                <UserClass name={"Rahul Kumar(class based)"} location={"Patna Class"}/> /** it will start loading userclass by instanting class  */
                <UserClass name={"Pragya Singh(class based)"} location={"Patna Class"}/>
            </div>
            
        );
    }
}
/*
1. Parent const
2.Parent render
    2.1 trigger child  component-> Rahul Constructor,Rahul Render
    2.2 trigger pragya child life cycle-> constructore,render
    2.3 Rahul did mount
    2.4 pragya did mount
3. Parent did mount will be called

*/
// const About=()=>{
//     return (
//         <div>
//             <h1>About</h1>
//             <h2>This is Namaste react web series</h2>
//             <User name={"Rahul Kumar(function)"}/>
//             <UserClass name={"Rahul Kumar(class based)"} location={"Patna Class"}/> /** it will start loading userclass by instanting class  */
//         </div>
        
//     );
// }
export default About;