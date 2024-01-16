import React from "react";
import { Shimmer } from "../components/Shimmer";
class UserClass extends React.Component{
    /* 
    React will know this is class based component
    1st constructor is called then render
    */
    constructor(props){
        super(props); /* it will intialize the constructor of React*/
        this.state={ /* state variablie hook like usestate */
            count:0,
            count2:1,
            userInfo:{
                name:"location",
                location:"Default"
            }
        }
        console.log(this.props.name+" child user cons")
    }
    increaseCount(){
        this.setState({
            count:this.state.count+1,
            count2:this.state.count2+1,
        })
    }
   async componentDidMount(){
        /*when const,render class after then this is called*/
          console.log(this.props.name+"child-did mount-");
          const data=await fetch("https://api.github.com/users/mynamerahulkumar");
          const json= await data.json();
          this.setState({
            userInfo:json,
          })
          console.log(json)

    }

    componentDidUpdate(){
        console.log("did update component-called")
    }
    componentWillUnmount(){
        console.log("Just before unmounted");
    }

   render(){
    console.log(this.props.name+"child-render-")
    /*
    it will return some piece of jsx
    */
   //const{name,location}=this.props;
   const{count,count2}=this.state;
   
   const{name,location,avatar_url}=this.state.userInfo;
    return (<div  className="user-card">
    <h1>Count:{count}</h1>
    <h1>Count2:{count2}</h1>

    <button onClick={()=>{
        /* never update state variable directly this.state.count+1 */
        
            this.increaseCount();
    }
    }> Count Increase</button>
    <img src={avatar_url}></img>
    <h2>Name:{name}</h2>
    <h3>Location:{location}</h3>
    <h3>Twitter:@rahul12</h3>
    </div>)
   }
}
export default UserClass;
/*
https://projects.wojtekmaj.pl/react-lifecycle-methods-diagram/

 Mounting life cycle
 1.Constructor(dummy)
 2.Render(dummy)
    Html<dummy>
 3.Component did mount 
 <API call>
 <this.setstate>  -state variable update 

 update cycle

  render(API data)
   html loaded with API data 

   componendt did update called 


*/