import RestaurantCard, { withPromotedLabel } from "./RestaurantCard";
import { restList } from "../utils/data";
import { Shimmer } from "./Shimmer";
import { useState,useEffect,useContext } from "react";
import { Link } from "react-router-dom";
import UserContext from "../utils/UserContext";
const Body=()=>{
    // state variable-super powerful variable 
    const [listOfrestListRestaurant,setListofRestaurant]=useState([]); // default values can be also passed ,updated data in set variable

    const[filteredListRestaurant,setFilteredList]=useState([]);
    
    const[searchText,setSearchText]=useState("");

    const RestaurantCardPromoted=withPromotedLabel(RestaurantCard); // it has return method return()
    const{loggedInUser,setUserName}=useContext(UserContext);
    useEffect(()=>{
        fetchData();


        console.log("when body component loaded then it will render it again with this call back function");
    },[])
  const fetchData=async ()=>{
    // const data= await fetch("https://corsproxy.io/?http://localhost:8080/restaurant/menu/v1");
    const data= await fetch("http://localhost:8080/restaurant/menu/v1")
    .catch(err=>{
        console.log("Menu error");
    });

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
         <div className="filter flex"> 
            <div className="search m-4 p-4">
                <input type="text" className="border border-solid border-black"
                value={searchText} 
                onChange={(e)=>{
                    setSearchText(e.target.value);
                }}
                ></input>
            
                <button className="p-4 py-2 bg-green-100 m-4 rounded-lg"
                onClick={async ()=>{
                   await fetchData();
                  const filterrestaurant=  listOfrestListRestaurant.filter((res)=>
                        res.name.toLowerCase().includes(searchText.toLowerCase()));
                        setFilteredList(filterrestaurant);
                        console.log(searchText);
                }}
                >Search</button>
             </div>
            <div className="search m-4 p-4 flex items-center">
            <button className="filter-btn px-4 py-2 bg-gray-100 rounded-lg" onClick={()=>{
               const restListFilter=listOfrestListRestaurant.filter(
                (res)=>res.avgRating>4.5
                );
                console.log("filter-applied"+restListFilter);
                setListofRestaurant(restListFilter);
            }} 
            >
                        Top Rated Button
            </button>
            <div className=" m-4 p-4 flex items-center">
            <label>UserName:</label>
            <input type="text" className="border border-black p-2" value={loggedInUser} onChange={(e)=>setUserName(e.target.value)}></input>
            </div>
            </div>
          
          </div>
            <div className="flex flex-wrap rounded-lg">
               {
                filteredListRestaurant?.map((restaurant,index)=>
                <Link to={"/restaurant/"+restaurant.id} key={restaurant.id}>
               {/* if the restuant card promoted show promoted label        */}
               {restaurant.promoted?(
                <RestaurantCardPromoted restData={restaurant} indexData={restaurant.id}/> 
               ):(
                <RestaurantCard  restData={restaurant} indexData={restaurant.id} />
               )}
                
                </Link>
                )}      
            </div>

        </div>
    )

}

export default Body;