import { createSlice } from "@reduxjs/toolkit";


const cartSlice=createSlice({
    name:'cart',
    initialState:{
        items:[],
    },
    reducers:{
        addItem:(state,action)=>{
            //mutating the state over here ,directly modify the existing state
            state.items.push(action.payload);
        },
        removeItem:(state,action)=>{
            state.items.pop(); 
            // we can removed based on index
        },
        clearCart:(state,action)=>{
                state.items.length=0;
        },
    }
});
export const{addItem,removeItem,clearCart}=cartSlice.actions;
export default cartSlice.reducer;