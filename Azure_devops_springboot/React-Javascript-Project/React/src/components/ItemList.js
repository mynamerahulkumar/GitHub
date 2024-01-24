const ItemList=({items})=>{
    console.log(items)
    return (
        <div >
           {items.map((item)=>(
            <div key={item.id} className="p-2 m-2 border-black border-b-2 text-left">
                <div className="py-2">
                <span>{item.name}</span>
                <span>-₹{item.price}</span>
                </div>
                <div>
                <p className="text-xs">{item.description}</p>
                </div>
            </div>
          
           ))}
        </div>
    )
}

export default ItemList;