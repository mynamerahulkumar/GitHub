import { useDispatch, useSelector } from "react-redux";
import { toggleMenu } from "../utils/appSlice";
import { useEffect, useState } from "react";
import { YOUTUBE_SEARCH_URL } from "../utils/Constants";
import store from "../utils/store";
import { cacheResults } from "../utils/searchSlice";

const Header=()=>{
    const dispatch=useDispatch();
    const[searchQuery,SetSearchQuery]=useState("");
    const[suggestion,setSuggestions]=useState([]);
    const searchCache=useSelector((store)=>store.search);
    /**
     * searchCache={
     *  "iphone":["iphone11","iphone 14"]
     * }
     * searchQuery="iphone"
     * 
     */
    const dispatch=useDispatch();
    const[showSuggestion,setShowSuggestion]=useState(false);


    useEffect(()=>{
        const timer=setTimeout(()=> {
        if(searchCache[searchQuery]){
            setShowSuggestion(searchCache[searchQuery]);
        }
        else{
            callSearchQuery();
        }

        },300);
        return()=>{
            clearTimeout(timer);
        }
      
    },[searchQuery])
    const callSearchQuery= async ()=>{
        console.log("API search call")
            const data= await fetch(YOUTUBE_SEARCH_URL+searchQuery);
            const json=await data.json();
            setSuggestions(json[1]);
            console.log("API response-"+json[1]);
            console.log("API call-"+searchQuery);
            //  send the object
            dispatch(cacheResults(
                {
                    [searchQuery]:json[1]
                }
            ))
    }

    const toggleMenuHandler=()=>{
        dispatch(toggleMenu());
    }
    return (
        <div className="grid grid-flow-col p-5 m-2 shadow-lg">
        <div className="flex col-span-3" >
           <img  className="h-8 m-2 cursor-pointer"
           onClick={()=>toggleMenuHandler()}
           alt="hamburger-icon" src="https://upload.wikimedia.org/wikipedia/commons/b/b2/Hamburger_icon.svg"
           />
           <a href="/">
           <img className="h-8 m-2 w-50"
            alt="youtube-logo" src="https://upload.wikimedia.org/wikipedia/commons/e/e1/Logo_of_YouTube_%282015-2017%29.svg"/>
            </a>
        </div>
        <div className="col-span-10 px-10">
        <div>
            <input className="h-8 border  w-1/2 border-gray-400 p-2 rounded-l-full"
            value={searchQuery}
            onInput={(e)=>SetSearchQuery(e.target.value)}
            onFocus={()=>setShowSuggestion(true)}
            onBlur={()=>setShowSuggestion(false)}
            type="text"/>
            <button className="border border-gray-400 roundel-r-full bg-gray-100 px-5 py-2">
            🔍
            </button>
            </div>
            <div className="fixed bg-white w-1/4 rounded-lg shadow-lg border-gray-100">
                <ul>
              {  suggestion.map((s)=>(
                <li className="py-2 shadow-sm" key={s}>🔍{s}</li>
                ))
              }
                    
                </ul>
            </div>
        </div>
        <div className="col-span-1 px-10">
            <img className="h-8"
            alt="user-icon" src="https://e7.pngegg.com/pngimages/178/595/png-clipart-user-profile-computer-icons-login-user-avatars-monochrome-black-thumbnail.png"/>

        </div>
        </div>
    )
}
export default Header;