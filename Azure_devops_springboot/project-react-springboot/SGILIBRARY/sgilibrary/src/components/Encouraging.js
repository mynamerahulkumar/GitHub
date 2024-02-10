
import {useEffect, useState}  from 'react';
import {  EncourageMentQuoteMap } from '../utils/EncourageConstant';
import Shimmer from '../utils/Shimmer';
const Encouraging=()=>{
    let dateMonthName='';
    const[quoteToday,setQuoteToday]=useState('');
    let quoteText='';
    useEffect(() => {
        loadEncouragment();
      }, []);

        const loadEncouragment= async()=>{
            getDateMonth();
            const quotesMap=EncourageMentQuoteMap;
            quoteText= quotesMap.get(dateMonthName).quote;
            console.log(quoteText);
          setQuoteToday(quoteText);
        }

        const getDateMonth=async()=>{
            const newDate=new Date();
            let date=newDate.getDate();
            
            let month=newDate.getMonth();
            console.log('date-month-'+month);
            let monthName='';
            switch(month){
                case 0:
                    monthName='january';
                    break;
                case 1:
                    monthName='february'; 
                    break;
                case 2:
                    monthName='march';  
                    break;
                case 3:  
                     monthName='april';  
                     break;    
                case 4:
                    monthName='may'; 
                    break;
                case 5:
                    monthName='june'; 
                    break;
                 case 6:
                    monthName='july'; 
                    break;
                 case 7:
                    monthName='august'; 
                    break;
                 case 8:
                    monthName='september'; 
                    break;
                 case 9:
                    monthName='october'; 
                    break;
                 case 10:
                    monthName='november';
                    break;
                 case 11:
                    monthName='december';
                    break;
                 default:
                    monthName='january';                                
            }
            dateMonthName=  (monthName+'-'+date);
            return dateMonthName;

        }
    
        return (
            <div className='bg-red-50 text-center text-wrap'>
            <h1>
            
            
            {quoteToday}</h1>
            
            </div>
        )
}

export default Encouraging;