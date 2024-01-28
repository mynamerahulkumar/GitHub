import ItemList from "./ItemList";
import {useState} from 'react';

const RestauarantCategory=({data,showItems,setIndexShow})=>{
    console.log(data);
    /** const[showItems,setShowItems]=useState(false)**/
     const handleClick=()=>{
        setIndexShow();
    }  
 return (
        <div>
        <div className="w-6/12 mx-auto my-4 bg-gray-50 p-4 shadow-lg ">
    
        {/* Header */}

        <div className="flex justify-between cursor-pointer" onClick={handleClick}>
        <span className="font-bold text-lg">{data.name} ({data.itemDTO.length})</span>
        <span>⬇️</span>
        </div>
       {showItems && <ItemList items={data.itemDTO}/>}
        </div>
        </div>
    )
}
export default RestauarantCategory;