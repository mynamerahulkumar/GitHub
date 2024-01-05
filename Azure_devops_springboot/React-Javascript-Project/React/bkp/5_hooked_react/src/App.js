import React from "react";
import ReactDOM from "react-dom/client";


import Body from "./components/body";
import Header from "./components/Header";
/*** 
 * Header
 * - Logo
 * -Nav Items (Home ,about us)
 * Body
 * -Search component
 * -Restaurant container
 *    -Restaurant card 
 *      -image,name of res,star rating ,cuisines,deliver times
 * Footer
 *  - Copuright
 *   -Links
 *   -Address
 *    -Contact
 */








const AppLayout=()=>{
    return (
        <div className="app">
            <Header/>
            <Body/>
        </div>
    )
}

const root=ReactDOM.createRoot(document.getElementById("root"));

root.render(<AppLayout/>);