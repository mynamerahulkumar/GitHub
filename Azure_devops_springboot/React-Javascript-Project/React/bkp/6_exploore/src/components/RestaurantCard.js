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
     return(   <div className="res-card" style={styleCard}>
        <img className="res-logo" alt="res-logo" 
        src={images[indexData]} />

            <h3>{name}</h3>
            <h4>{cuisines}</h4>
            <h4>{avgRating}🌟</h4>
            <h4>₹{costForTwo/100} FOR TWO </h4>
            <h4>{deliveryTime}  Minutes</h4>
        </div>
     )
}

export default RestaurantCard;