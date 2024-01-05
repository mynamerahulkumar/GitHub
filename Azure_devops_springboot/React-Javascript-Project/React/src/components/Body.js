import RestaurantCard from "./RestaurantCard";
import { restList } from "../utils/data";
import { Shimmer } from "./Shimmer";
import { useState,useEffect } from "react";
const Body=()=>{
    // state variable-super powerful variable 
    const [listOfrestListRestaurant,setListofRestaurant]=useState([]); // default values can be also passed ,updated data in set variable

    const[filteredListRestaurant,setFilteredList]=useState([]);
    
    const[searchText,setSearchText]=useState("");
    useEffect(()=>{
        fetchData();


        console.log("when body component loaded then it will render it again with this call back function");
    },[])
  const fetchData=async ()=>{
    const data= await fetch("http://localhost:8080/restaurant/menu/v1");
    const json=await data.json();
    console.log("response-"+json.Body);
    setListofRestaurant(json);
    setFilteredList(json);
    
  }
  if(listOfrestListRestaurant.length===0){
        <Shimmer/>
  }
 


    console.log("body rendered fast");
    //Normal JS variable let listofrestaurant=[];
    return(
        <div className="body">
            <div className="filter"> 
            <div className="search">
                <input type="text" className="search-box"
                value={searchText} 
                onChange={(e)=>{
                    setSearchText(e.target.value);
                }}
                ></input>
                <button 
                onClick={async ()=>{
                   await fetchData();
                  const filterrestaurant=  listOfrestListRestaurant.filter((res)=>
                        res.name.toLowerCase().includes(searchText.toLowerCase()));
                        setFilteredList(filterrestaurant);
                        console.log(searchText);
                }}
                >Search</button>
                   
                
               
            </div>
            <button className="filter-btn" onClick={()=>{
               const restListFilter=listOfrestListRestaurant.filter(
                (res)=>res.avgRating>4.5
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
                filteredListRestaurant?.map((restaurant,index)=><RestaurantCard  restData={restaurant} indexData={restaurant.id} key={restaurant.id}/>)
               }      
            </div>

        </div>
    )

}

export default Body;