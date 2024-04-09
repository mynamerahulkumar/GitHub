import { useEffect, useState } from "react"

const useAllMenuRestaurant=()=>{
    const[resMenu,setRestMenu]=useState([]);

    useEffect(()=>{
        fetchData();
    },[])

    const  fetchData=async()=>{
        const data= await fetch('http://localhost:8080/restaurant/menu/v1');
        const json=data.json();
        setRestMenu(resMenu);
    }
    return resMenu;
}
export default useAllMenuRestaurant;