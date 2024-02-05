import React,{useEffect} from 'react'
import { useDispatch } from 'react-redux'
import { closeMenu } from '../utils/appSlice';
import { useSearchParams } from 'react-router-dom';

const WatchPage = () => {
    const dispatch=useDispatch();
    const [searchParams]=useSearchParams();
    console.log(searchParams.get("v"));
    useEffect(()=>{
        dispatch(closeMenu());
    })
  return (
    <div>
        <iframe width="1200" 
        height="700" 
        className='p-2 m-2 rounded-lg'
        src={"https://www.youtube.com/embed/"+searchParams.get("v")}
        >
        </iframe>
    </div>
  )
}

export default WatchPage