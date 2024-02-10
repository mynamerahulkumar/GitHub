import Encouraging from "./Encouraging";
import SubHeader from "./SubHeader";


const Header=()=>{

    return(
        <div>
        <div className='flex bg-blue-100 shadow-lg flex-wrap'>
            <img alt='sgi-logo' 
              className='w-40 h-15 '
             src='https://www.sokaglobal.org/wp-content/themes/soka/assets/img/logo01_pc.png'
             />
           
            {/* <img alt='lib-logo'
            className='w-40 h-20 px-10'
            src='https://lh3.googleusercontent.com/proxy/xZNSlUTPEUlNn-G9RZS1_Q9VYxFThhtFbdGawWO1MSemaKmaUoIzHMp9y4uLIvLktPB5wPvReyzdg8kL3O1Kv_prGZUDgIds-9SzXv9DknPKVcnxzhetIdx6hIHS98p9kJ6G'
            /> */}
            <h1 className="font-bold text-2xl p-2 text-cyan-500">Library📖📙</h1>
        </div>
       
        <SubHeader/>
        
        </div>
    )
}

export default Header;