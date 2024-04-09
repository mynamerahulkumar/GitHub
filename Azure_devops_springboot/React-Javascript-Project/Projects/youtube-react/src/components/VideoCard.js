import Shimmer from "../utils/Shimmer";

const VideoCard=({video_info})=>{
    if(video_info===undefined){
        return (
            <Shimmer/>
        )
    }


    const{snippet,statistics}=video_info;

    const{channelTitle,title,thumbnails}=snippet;
    const{viewCount}=statistics;

    return(
        <div className="p-2 m-2 w-80 shadow-lg">
        <img alt="thumbnail" src={thumbnails.medium.url}/>
        <ul>
            <li className="font-bold py-2">{title}</li>
            <li>{channelTitle}</li>
            <li>{viewCount} views</li>
        </ul>
        </div>
    )
}

export default VideoCard;