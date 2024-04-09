import RestaurantCard from "./RestaurantCard";
import { restList } from "../utils/data";

import { useState } from "react";
const Body=()=>{
    // state variable-super powerful variable 
    const [listOfrestListRestaurant,setListofRestaurant]=useState(restList); // default values can be also passed ,updated data in set variable
    console.log("data-full-"+listOfrestListRestaurant);
    //Normal JS variable let listofrestaurant=[];
    return(
        <div className="body">
            <div className="filter"> 
            <button className="filter-btn" onClick={()=>{
               const restListFilter=listOfrestListRestaurant.filter(
                (res)=>res.data.avgRating>4.5
                );
                console.log("filter-applied"+restListFilter);
                setListofRestaurant(restListFilter);
            }} 
            >
                        Top Rated Button
            </button>
            </div>
            <div className="res-container">
               {
                listOfrestListRestaurant.map((restaurant,index)=><RestaurantCard  restData={restaurant} indexData={index} key={restaurant.data.id}/>)
               }      
            </div>

        </div>
    )

}

export default Body;