import React,{useEffect} from 'react'
import { useDispatch } from 'react-redux'
import { closeMenu } from '../utils/appSlice';
import { useSearchParams } from 'react-router-dom';
import CommentContainer from './CommentsContainer';

const WatchPage = () => {
    const dispatch=useDispatch();
    const [searchParams]=useSearchParams();
    console.log(searchParams.get("v"));
    useEffect(()=>{
        dispatch(closeMenu());
    })
  return (
    <div>
        <iframe width="1000" 
        height="500" 
        className='p-2 m-2 rounded-lg'
        src={"https://www.youtube.com/embed/"+searchParams.get("v")}
        >
        </iframe>
      <div>
    <CommentContainer/>
    </div>
    </div>
   
    
  )
}

export default WatchPage