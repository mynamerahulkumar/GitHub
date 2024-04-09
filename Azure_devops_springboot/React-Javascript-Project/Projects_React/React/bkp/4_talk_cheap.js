import React from "react";
import ReactDOM from "react-dom/client";

import { images } from "./image";
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

const Header=()=>{
    return (
        <div className="header">
            <div className="logo-container">
               <img className="logo" src={require('/assets/images/food_logo.png')} />
            </div>
           <div className="nav-items">
            <ul>
                <li>Home</li>
                <li>About Us</li>
                <li>Contact Us</li>
                <li>Cart</li>
            </ul>
           </div>

        </div>
    )
}
const styleCard={
    backgroundColor:"#f0f0f0",
};
const RestaurantCard=(props)=>{
    const{restData,indexData}=props;
    console.log(props)
    const{name,
        cuisines,
        avgRating,
        costForTwo,
        deliveryTime,
        imageId
    }=restData?.data;
    const imageUrl="/images/" + imageId;
     return(   <div className="res-card" style={styleCard}>
        <img className="res-logo" alt="res-logo" 
        src={images[indexData]} />

            <h3>{name}</h3>
            <h4>{cuisines.join(",")}</h4>
            <h4>{avgRating}🌟</h4>
            <h4>₹{costForTwo/100} FOR TWO </h4>
            <h4>{deliveryTime}  Minutes</h4>
        </div>
     )
}
const restList=[{
 type:"restaurant",
 data:{

    type:"F",
    id:0,
    name:"Biryani",
    avgRating:"4.1",
    costForTwo:50000,
    deliveryTime:30,
    cuisines:["Burgers","Biryani","Snacks","Fast Food"],
    imageId:'f1.jpg'
 }
},
{
    type:"restaurant",
    data:{
       type:"F",
       id:1,
       name:"South Indian Thali",
       avgRating:"4.5",
       costForTwo:40000,
       deliveryTime:30,
       cuisines:["Burgers","Biryani","Snacks",,"Thali","Fast Food"],
       imageId:'f2.jpg'
    }
   },
   {
       type:"restaurant",
       data:{
          type:"F",
          id:3,
          name:"Kachodi",
          avgRating:"4.3",
          costForTwo:45000,
          deliveryTime:30,
          cuisines:["Burgers","Biryani","Snacks","Fast Food"],
          imageId:'f3.jpg'
       }
      },
      {
          type:"restaurant",
          data:{
             type:"F",
             id:4,
             name:"Idli",
             avgRating:"4.7",
             costForTwo:30000,
             deliveryTime:20,
             cuisines:["Burgers","Biryani","Snacks","Fast Food"],
             imageId:'f4.webp'
          }
         },
         {
             type:"restaurant",
             data:{
                type:"F",
                id:5,
                name:"Biryani Thali",
                avgRating:"4.9",
                costForTwo:50000,
                deliveryTime:35,
                cuisines:["Burgers","Biryani","Snacks","Fast Food"],
                imageId:'f5.jpg'
             }
            },
            {
                type:"restaurant",
                data:{
                   type:"F",
                   id:6,
                   name:"Curd Chart",
                   avgRating:"4.8",
                   costForTwo:44000,
                   deliveryTime:30,
                   cuisines:["Burgers","Biryani","Snacks","Fast Food"],
                   imageId:'f6.jpg'
                }
               },
               {
                   type:"restaurant",
                   data:{
                      type:"F",
                      id:7,
                      name:"North Indian Roti Thali",
                      avgRating:"3.9",
                      costForTwo:46000,
                      deliveryTime:30,
                      cuisines:["Burgers","Biryani","Snacks","Fast Food"],
                      imageId:'f7.jpg'
                   }
                  },
                  {
                      type:"restaurant",
                      data:{
                         type:"F",
                         id:8,
                         name:"North Indian Thali",
                         avgRating:"4.5",
                         costForTwo:40000,
                         deliveryTime:20,
                         cuisines:["Burgers","Biryani","Snacks","Fast Food"],
                         imageId:'f8.jpg'
                      }
                     },
                     {
                         type:"restaurant",
                         data:{
                            type:"F",
                            id:9,
                            name:"South Indian Big Thali",
                            avgRating:"4.6",
                            costForTwo:60000,
                            deliveryTime:30,
                            cuisines:["Burgers","Biryani","Snacks","Fast Food"],
                            imageId:'f9.jpg'
                         }
                        },
                        {
                            type:"restaurant",
                            data:{
                               type:"F",
                               id:10,
                               name:"Jalebi",
                               avgRating:"4",
                               costForTwo:20000,
                               deliveryTime:30,
                               cuisines:["Burgers","Biryani","Snacks","Fast Food"],
                               imageId:'f10.jpg'
                            }
                           },
                           {
                               type:"restaurant",
                               data:{
                                  type:"F",
                                  id:11,
                                  name:"North Indian Medium Thali",
                                  avgRating:"4.4",
                                  costForTwo:40000,
                                  deliveryTime:30,
                                  cuisines:["Burgers","Biryani","Snacks","Fast Food"],
                                  imageId:'f11.jpg'
                               }
                              },
                              {
                                  type:"restaurant",
                                  data:{
                                     type:"F",
                                     id:"14341",
                                     name:"Rasgulla",
                                     avgRating:"4.2",
                                     costForTwo:20000,
                                     deliveryTime:30,
                                     cuisines:["Burgers","Biryani","Snacks","Fast Food"],
                                     imageId:'f12.jpg'
                                  }
                                 },
                                 {
                                     type:"restaurant",
                                     data:{
                                        type:"F",
                                        id:"1434",
                                        name:"Rice Roti Curry",
                                        avgRating:"4.1",
                                        costForTwo:30000,
                                        deliveryTime:30,
                                        cuisines:["Burgers","Biryani","Snacks","Fast Food"],
                                        imageId:'f13.webp'
                                     }
                                    },
                                    {
                                        type:"restaurant",
                                        data:{
                                           type:"F",
                                           id:345,
                                           name:"Kachodi",
                                           avgRating:"4.3",
                                           costForTwo:45000,
                                           deliveryTime:30,
                                           cuisines:["Burgers","Biryani","Snacks","Fast Food"],
                                           imageId:'f3.jpg'
                                        }
                                       },
                                       {
                                           type:"restaurant",
                                           data:{
                                              type:"F",
                                              id:454,
                                              name:"Idli",
                                              avgRating:"4.7",
                                              costForTwo:30000,
                                              deliveryTime:20,
                                              cuisines:["Burgers","Biryani","Snacks","Fast Food"],
                                              imageId:'f4.webp'
                                           }
                                          },
                                          {
                                              type:"restaurant",
                                              data:{
                                                 type:"F",
                                                 id:5245,
                                                 name:"Biryani Thali",
                                                 avgRating:"4.9",
                                                 costForTwo:50000,
                                                 deliveryTime:35,
                                                 cuisines:["Burgers","Biryani","Snacks","Fast Food"],
                                                 imageId:'f5.jpg'
                                              }
                                             },
                                             {
                                                 type:"restaurant",
                                                 data:{
                                                    type:"F",
                                                    id:625,
                                                    name:"Curd Chart",
                                                    avgRating:"4.8",
                                                    costForTwo:44000,
                                                    deliveryTime:30,
                                                    cuisines:["Burgers","Biryani","Snacks","Fast Food"],
                                                    imageId:'f6.jpg'
                                                 }
                                                },
];

const Body=()=>{
    return(
        <div className="body">
            <div className="search"> Search
            </div>
            <div className="res-container">
               {
                restList.map((restaurant,index)=><RestaurantCard  restData={restaurant} indexData={index} key={restaurant.data.id}/>)
               }       
            </div>

        </div>
    )
}

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