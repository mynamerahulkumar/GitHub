import ItemList from "./ItemList";

const RestauarantCategory=({data})=>{
    console.log(data);
    return (
        <div>
        <div className="w-6/12 mx-auto my-4 bg-gray-50 p-4 shadow-lg ">
    
        {/* Header */}

        <div className="flex justify-between">
        <span className="font-bold text-lg">{data.name} ({data.itemDTO.length})</span>
        <span>⬇️</span>
        </div>
        <ItemList items={data.itemDTO}/>
        </div>
        </div>
    )
}
export default RestauarantCategory;