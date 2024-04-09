import { useContext, useEffect, useState } from "react";
import RestaurantCard from "./RestaurantCard"
import { Shimmer } from "./Shimmer";
import { useParams } from "react-router-dom";

const RestaurantMenu=()=>{
    const{restId}=useParams();
    console.log('params-'+restId)
    const[restItem,setRestMenu]=useState(null);
    useEffect(()=>{
        fetchMenu();
    },[]);
    
    const fetchMenu= async()=>{
        const data= await fetch("http://localhost:8080/restaurant/item/v1?restId="+restId)
        .catch(err=>{
            console.log("Menu error");
        });
        const json=await data.json();
        console.log("items-"+json);
        setRestMenu(json);

    }
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