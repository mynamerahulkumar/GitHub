import React,{useEffect,useState} from 'react'
import { YOUTUBE_VIDEO_API } from '../utils/Constants';
import VideoCard from './VideoCard';
import Shimmer from '../utils/Shimmer';
import { Link } from 'react-router-dom';

const VideoContainer = () => {
    const[videos,setVideos]=useState([]);
    useEffect(()=>{
      
        getVideos();
    })
    const getVideos=async()=>{
        const data=await fetch(YOUTUBE_VIDEO_API);
        const json= await data.json();
        setVideos(json.items)
    }
    if(videos===undefined){
        return(
            <Shimmer/>
        )
    }
  return (
    <div className='flex flex-wrap'>
        {videos.map((video,index)=>(
           <Link to={"/watch?v=" +video.id}> <VideoCard video_info={video} key={video.id} /></Link>
        ))}
        
    </div>
  )
}

export default VideoContainer;