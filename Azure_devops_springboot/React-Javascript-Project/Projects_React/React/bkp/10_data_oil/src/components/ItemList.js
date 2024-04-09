import { images } from "../utils/image";

const ItemList=({items})=>{
    console.log(items)
    return (
        <div >
           {items.map((item,index)=>(
            <div key={item.id} className="p-2 m-2 border-black border-b-2 text-left flex justify-between">
                <div className="w-9/12">
                    <div className="py-2">
                        <span>{item.name}</span>
                        <span>-₹{item.price}</span>
                    </div>
                    <div>
                        <p className="text-xs">{item.description}</p>
                    </div>
                </div>
                <div className="w-3/12 p-4">
                <div className="absolute">
                <button className=" bg-black text-white shadow-lg mx-10">Add+</button>
                </div>
                <img src={images[index]} className="w-full"/>
                
                </div>
            </div>
          
           ))}
        </div>
    )
}

export default ItemList;