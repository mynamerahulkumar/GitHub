
import {configureStore} from "@reduxjs/toolkit"
import cartReducer from "./CartSlice";
const appStore=configureStore({
    reducer:{
        cart:cartReducer,
        //user:userReducer -user slice
    }
});

export default appStore;