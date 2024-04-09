import React from "react";
import ReactDOM from "react-dom/client";


import Body from "./components/body";
import Header from "./components/Header";
import {createBrowserRouter,RouterProvider,Outlet} from 'react-router-dom'
import About from "./components/About";
import Contact from "./components/Contact";
import Error from "./components/Errro";
import RestaurantMenu from "./components/RestaurantMenu";






const AppLayout=()=>{
    return (
        <div className="app">
            <Header/>
            <Outlet/>{/**render the children */}
        </div>
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
                path:"/restaurant/:restId",
                element:<RestaurantMenu/>
            }
        ],
        errorElement:<Error/>
    },
    
])
const root=ReactDOM.createRoot(document.getElementById("root"));

root.render(<RouterProvider router={appRouter}/>);