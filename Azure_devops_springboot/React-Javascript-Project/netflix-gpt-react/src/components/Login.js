import React from 'react'
import Header from './Header'

const Login = () => {
  return (
    <div>
    <div className='absolute'>
        <Header/>
        <img src='https://assets.nflxext.com/ffe/siteui/vlv3/4da5d2b1-1b22-498d-90c0-4d86701dffcc/b36244ca-dced-4bbe-b32d-fd23c257f4d8/IE-en-20240129-popsignuptwoweeks-perspective_alpha_website_large.jpg'
        alt="movie-bg"/>
        </div>
     <form className='w-3/12 absolute p-12 bg-black my-36 mx-auto right-0 left-0 text-white'>
     <h1 className='font-bold text-3xl py-4'>Sign In</h1>
      <input type='text' placeholder='Email Address' className='p-2 m-2 w-full'></input>
      <input type='password' placeholder='password' className='p-2 m-2 w-full'/>
      <button className='p-4 m-4 bg-red-600 w-full'>Sign In</button>
    </form>
    </div>
    
  )
}

export default Login