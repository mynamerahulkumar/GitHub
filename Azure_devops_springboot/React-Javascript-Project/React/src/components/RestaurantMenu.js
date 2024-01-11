import { useEffect, useState } from "react";
import RestaurantCard from "./RestaurantCard"

const RestaurantMenu=()=>{
    const[restInfoMenu,setRestMenu]=useState(null);
    useEffect(()=>{
        fetchMenu();
    },[]);
    
    const fetchMenu= async()=>{
        const data= await fetch()
        const json=await data.json();
    }

    return(
        <div className="menu">
        <h1>Name of the Restaurant</h1>
        <h2>Menu</h2>
        <ul>
            <li>Biryani</li>
            <li>Idli</li>
            <li>Kachodi</li>

        </ul>

        </div>
    )
}

export default RestaurantMenu;