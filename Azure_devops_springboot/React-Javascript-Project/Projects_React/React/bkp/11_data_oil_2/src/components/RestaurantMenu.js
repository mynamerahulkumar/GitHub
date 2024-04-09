import { useContext, useEffect, useState, useTransition } from "react";
import RestaurantCard from "./RestaurantCard"
import { Shimmer } from "./Shimmer";
import { useParams } from "react-router-dom";
import useRestaurantMenu from "../utils/useRestaurantMenu";
import RestauarantCategory from "./RestauarantCategory";

const RestaurantMenu=()=>{
    const{restId}=useParams();
    console.log('params-'+restId)
    const restItem=useRestaurantMenu(restId);
    const[indexShow,setIndexShow]=useState(0);
    
    if(restItem==null){
        return <Shimmer/>
    }
    console.log(restItem);
    const{name,cuisines,costFortTwoMessage,menuDTOList}=restItem;
    const categories=menuDTOList.filter(
        (c)=>c.category="Main_Course"
    )

    return(
        <div className="menu">
        <h1 className="font-bold my-10 text-2xl">{name}</h1>
        <h2 className="font-bold my-10 text-1xl">{cuisines.join(", ")} ={costFortTwoMessage}</h2>
        <h2>Menu</h2>
        {
            categories.map((category,index) => (
                <RestauarantCategory key={category.id} data={category}
                    showItems={index == indexShow ? true : false}
                    setIndexShow={()=>setIndexShow(index)}
                />
            ))
        }

        {/* {itemDTO.map((item,index)=>(
            <li key={index}> {item.name}- {item.price}</li>
        ))} */}
         
       

        </div>
    )
}

export default RestaurantMenu;