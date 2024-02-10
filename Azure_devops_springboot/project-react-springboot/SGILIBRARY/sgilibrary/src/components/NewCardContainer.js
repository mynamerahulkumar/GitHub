import React from 'react'
import NewCard from './NewCard'
import { NcName } from '../utils/NcJson'

const NewCardContainer = () => {
    const NhrChapterName=NcName;
  return (
    <div className='flex flex-wrap m-10'>
    {NhrChapterName.map((chapterName,index)=>(
        <NewCard title={chapterName.title} key={index} chaptId={chapterName.ch_id}/>
    ))
    }
        
    </div>
  )
}

export default NewCardContainer