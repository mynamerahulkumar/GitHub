import { baseImagePath } from "../utils/constants";
import { images } from "../utils/image";
const styleCard={
    backgroundColor:"#f0f0f0",
};
const RestaurantCard=(props)=>{
    const{restData,indexData}=props;
    const{name,
        cuisines,
        avgRating,
        costForTwo,
        deliveryTime,
        imageId
    }=restData;
    const imageUrl=baseImagePath + imageId;
     return(   <div className="res-card m-4 p-4 w-[300px] h-[380px] bg-gray-100 hover:bg-gray-200" 
     >
        <img className="res-logo rounded-lg" alt="res-logo" 
        src={images[indexData]} />

            <h3 className="font-bold py-3 text-lg">{name}</h3>
            <h4>{cuisines}</h4>
            <h4>{avgRating}🌟</h4>
            <h4>₹{costForTwo/100} FOR TWO </h4>
            <h4>{deliveryTime}  Minutes</h4>
        </div>
     )
}
// Higher order component
//input- Restaurantcard-RestaurantCard Promoted

const withPromotedLabel=(RestaurantCard)=>{
    return()=>{
        return(
            <div>
                <label>Promoted</label>
                <RestaurantCard/>
            </div>
        )
    }
}
export default RestaurantCard;