const RestauarantCategory=({data})=>{
    return (
        <div>
        {/* Header */}
        <span>{data.name}</span>
        <span>⬇️</span>
        </div>
    )
}
export default RestauarantCategory;