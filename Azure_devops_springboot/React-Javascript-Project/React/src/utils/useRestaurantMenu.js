import { useEffect, useState } from "react";

const useRestaurantMenu=(restId)=>{
    const[resInfo,setResInfo]=useState(null);
        useEffect(()=>{
            fetchMenu();
        },[] )/* empty array it will call only once */

    const fetchMenu= async()=>{
        const data= await fetch("http://localhost:8080/restaurant/item/v1?restId="+restId)
        .catch(err=>{
            console.log("Menu error");
        });
        const json=await data.json();
        console.log("items-"+json);
        setResInfo(json);

    }
     return resInfo;

}

export default useRestaurantMenu;