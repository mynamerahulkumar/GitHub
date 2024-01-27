import React, { Suspense, lazy, useEffect, useState } from "react";
import ReactDOM from "react-dom/client";


import Body from "./components/body";
import Header from "./components/Header";
import {createBrowserRouter,RouterProvider,Outlet} from 'react-router-dom'
import About from "./components/About";
import Contact from "./components/Contact";
import Error from "./components/Errro";
import RestaurantMenu from "./components/RestaurantMenu";
import { Shimmer } from "./components/Shimmer";
import UserContext from "./utils/UserContext";
/*
Dynamic bundling-break down app into smaller chunks
Lazy loading -when we go to grocery page come then grocery page loaded -on demand loading 
*/

const Grocery=lazy(()=>
    import("./components/Grocery")
);


const AppLayout=()=>{
    const[userName,setUserName]=useState('');
    useEffect(()=>{
        // call method
        const data="Rahul Singh";
        setUserName(data);
    },[]);
    return (
        <UserContext.Provider value={{loggedInUser:userName,setUserName}}>
        <div className="app">
            <Header/>
            <Outlet/>{/**render the children */}
        </div>
        </UserContext.Provider>
    )
}

const appRouter=createBrowserRouter([
    {
        path:"/",
        element:<AppLayout/>,
        children:[
            {
                path:"/",
                element:<Body/>
        
            },
            {
                path:"/about",
                element:<About/>
        
            },
            {
                path:"/contact",
                element:<Contact/>
            },
            {
               path:"/grocery",
               element:(
               <Suspense fallback={<h1>Loading...</h1>}><Grocery/></Suspense>)
            },
            {
                path:"/restaurant/:restId",
                element:<RestaurantMenu/>
            }
        ],
        errorElement:<Error/>
    },
    
])
const root=ReactDOM.createRoot(document.getElementById("root"));

root.render(<RouterProvider router={appRouter}/>);