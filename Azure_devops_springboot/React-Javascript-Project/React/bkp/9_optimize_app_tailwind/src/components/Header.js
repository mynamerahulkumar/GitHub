 import { useState } from 'react';
import { Link } from 'react-router-dom';
import useOnlineStatus from '../utils/useOnlineStatus';
 const Header=()=>{

    let btnName="Login";
    const[btnNameReact,setBtnName]=useState("Login");
    const onlineStatus=useOnlineStatus();
    return (
        <div className="flex justify-between bg-pink-100 shadow-lg sm:bg-yellow-50">
            <div className="logo-container">
               <img className="w-56" src={require('../../assets/images/food_logo.png')} />
            </div>
           <div className="flex items-center">
           <ul className="flex p-4 m-4">
            <li className='px-4'> Online Status{onlineStatus?"🟢":"🔴"}</li>
            <li className='px-4'><Link to="/">  Home</Link></li>
          <li className='px-4'>  <Link to="/about">About Us  </Link></li>
          <li className='px-4'>  <Link to="/contact">Contact Us</Link></li>
          <li className='px-4'><Link to="/grocery">Grocery</Link></li>
          <li className='px-4'> <Link to="/cart">Cart</Link></li> 
               
                <button className='login' onClick={()=>{
                   btnNameReact=="Login"? setBtnName("Logout"):setBtnName("Login");
                    console.log(btnName);
                }}>{btnNameReact} </button>
            </ul>
           </div>

        </div>
    )
};


export default Header;