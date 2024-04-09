import { useEffect } from "react";
import ChatMessage from "./ChatMessage";

const LiveChat=()=>{
  useEffect(()=>{
    const i=setInterval(()=>{
      console.log("API pollong")
    },2000);
    return()=>clearInterval(i);
  },[]);
    return(
        <div className=" w-full h-[500px] ml-2 p-2 borer border-black bg-slate-100 rounded-lg">
          <ChatMessage name="Rahul Kumar" message="Welcome to chatgpt assitant"/>
          <ChatMessage name="Rahul Kumar" message="Welcome to chatgpt assitant"/>
          <ChatMessage name="Rahul Kumar" message="Welcome to chatgpt assitant"/>
          <ChatMessage name="Rahul Kumar" message="Welcome to chatgpt assitant"/>
          <ChatMessage name="Rahul Kumar" message="Welcome to chatgpt assitant"/>
          <ChatMessage name="Rahul Kumar" message="Welcome to chatgpt assitant"/>
        </div>
    )
}

export default LiveChat;