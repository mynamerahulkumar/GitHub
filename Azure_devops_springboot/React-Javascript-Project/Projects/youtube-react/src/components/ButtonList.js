import React from 'react'
import Button from './Button'

const ButtonList = () => {
    const buttonList=["all","Music","Gaming","News","Valentines","Dev Gurukul","Movies","Play station",
    "Xbox","Tech","Dev Gurukul","Movies" ,"Play station","Xbox"]
  return (
    <div className='flex'>
        {
            buttonList.map((buttonName,index)=>(
                <Button name={buttonName} key={index}/>
        ))}

     
    </div>
  )
}

export default ButtonList