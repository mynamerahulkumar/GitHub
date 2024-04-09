import { useContext, useEffect, useState } from "react";
import RestaurantCard from "./RestaurantCard"
import { Shimmer } from "./Shimmer";
import { useParams } from "react-router-dom";
import useRestaurantMenu from "../utils/useRestaurantMenu";

const RestaurantMenu=()=>{
    const{restId}=useParams();
    console.log('params-'+restId)
    const restItem=useRestaurantMenu(restId);
    
    if(restItem==null){
        return <Shimmer/>
    }
    const{name,cuisines,costFortTwoMessage,itemDTO}=restItem;
    

    return(
        <div className="menu">
        <h1>{name}</h1>
        <h2>{cuisines.join(", ")} ={costFortTwoMessage}</h2>
        <h2>Menu</h2>
        <ul>
        {itemDTO.map((item,index)=>(
            <li key={index}> {item.name}- {item.price}</li>
        ))}
         
        </ul>

        </div>
    )
}

export default RestaurantMenu;