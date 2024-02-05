import { useDispatch } from "react-redux";
import { toggleMenu } from "../utils/appSlice";

const Header=()=>{
    const dispatch=useDispatch();
    const toggleMenuHandler=()=>{
        dispatch(toggleMenu());
    }
    return (
        <div className="grid grid-flow-col p-5 m-2 shadow-lg">
        <div className="flex col-span-3" >
           <img  className="h-8 m-2 cursor-pointer"
           onClick={()=>toggleMenuHandler()}
           alt="hamburger-icon" src="https://upload.wikimedia.org/wikipedia/commons/b/b2/Hamburger_icon.svg"
           />
           <a href="/">
           <img className="h-8 m-2 w-50"
            alt="youtube-logo" src="https://upload.wikimedia.org/wikipedia/commons/e/e1/Logo_of_YouTube_%282015-2017%29.svg"/>
            </a>
        </div>
        <div className="col-span-10 px-10">
            <input className="h-8 border  w-1/2 border-gray-400 p-2 rounded-l-full"
            type="text"/>
            <button className="border border-gray-400 roundel-r-full bg-gray-100 px-5 py-2">
            🔍
            </button>
        </div>
        <div className="col-span-1 px-10">
            <img className="h-8"
            alt="user-icon" src="https://e7.pngegg.com/pngimages/178/595/png-clipart-user-profile-computer-icons-login-user-avatars-monochrome-black-thumbnail.png"/>

        </div>
        </div>
    )
}
export default Header;