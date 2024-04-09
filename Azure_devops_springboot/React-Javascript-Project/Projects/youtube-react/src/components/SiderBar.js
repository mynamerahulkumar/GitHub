import { useSelector } from "react-redux";
import store from "../utils/store";
import { Link } from "react-router-dom";

const SideBar=()=>{
    const isMenuOpen=useSelector((store)=>store.app.isMenuOpen);
    if(!isMenuOpen){
        return null;
    }
    return (
        <div className="p-5 shadow-lg w-48">
          
           <ul>
           <Link to="/"><li>Home</li></Link>
            <li>Shorts</li>
            <li>Vidoes</li>
            <li>News</li>
            <li>Sports</li>
           </ul>
           <h1 className="font-bold pt-5">Subscriptions</h1>
           <ul>
            <li>Music</li>
            <li>Gaming</li>
            <li>Movie</li>
            <li>News</li>
            <li>Sports</li>
           </ul>
           <h1 className="font-bold pt-5">Watch Later</h1>
           <ul>
            <li>Music</li>
            <li>Gaming</li>
            <li>Movie</li>
            <li>News</li>
            <li>Sports</li>
           </ul>
        </div>
    )
}

export default SideBar;