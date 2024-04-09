 import { useState } from 'react';
import { Link } from 'react-router-dom';
 const Header=()=>{

    let btnName="Login";
    const[btnNameReact,setBtnName]=useState("Login");
    return (
        <div className="header">
            <div className="logo-container">
               <img className="logo" src={require('../../assets/images/food_logo.png')} />
            </div>
           <div className="nav-items">
           <ul>
            
            <li><Link to="/">  Home</Link></li>
          <li>  <Link to="/about">About Us  </Link></li>
          <li>  <Link to="/contact">Contact Us</Link></li>
          <li> <Link to="/cart">Cart</Link></li> 
               
                <button className='login' onClick={()=>{
                   btnNameReact=="Login"? setBtnName("Logout"):setBtnName("Login");
                    console.log(btnName);
                }}>{btnNameReact} </button>
            </ul>
           </div>

        </div>
    )
}

export default Header;