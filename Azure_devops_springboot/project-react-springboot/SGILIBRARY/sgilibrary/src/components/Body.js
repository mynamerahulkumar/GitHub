import React from 'react'
import Encouraging from './Encouraging'
import NewCardContainer from './NewCardContainer'
import { Outlet } from 'react-router-dom'

const Body = () => {
  return (
    <div>
       
        <Encouraging/>
        <Outlet/>

        
    </div>
  )
}

export default Body