import React from 'react'
import { Link } from 'react-router-dom'

const NewCard = ({title,chaptId}) => {

  return (
   <div className=' m-20 p-4 w-[300px] h-[380px] bg-gray-100 hover:bg-gray-200 cursor-pointer'
   >
        <Link to={`/${chaptId}`}>
        <div className=''>
        <h1 className='font-bold text-2xl'>{title}</h1>
        </div>
        <div className=''>
        <img className='w-[250px] h-[300px] py-4 px-2'
         alt='nhr-30' src='https://www.eternalganges.com/Handler/Eg-ThumbNailImage.ashx?imgpath=https://www.eternalganges.com/uploads/bookimages/egres-books/1052.jpg&height=428'
        />
       
        </div>
        </Link>
    </div>
  )
}

export default NewCard