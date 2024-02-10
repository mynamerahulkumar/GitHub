import logo from './logo.svg';
import './App.css';
import Header from './components/Header';
import Body from './components/Body';
import { RouterProvider, createBrowserRouter} from 'react-router-dom';
import Ch1Vol30 from './NhUtils/Ch1Vol30';
import Ch2Vol30 from './NhUtils/Ch2Vol30';
import Ch3Vol30 from './NhUtils/Ch3Vol30';
import { Ch4Vol30 } from './NhUtils/Ch4Vol30';
import { Ch5Vol30 } from './NhUtils/Ch5Vol30';
import Ch6Vol30 from './NhUtils/Ch6Vol30';
import NewCardContainer from './components/NewCardContainer';
import Ch1V30GM1_10 from './NhChapterSlice/Ch1V30GM1_10';
import Ch1V30GM11_20 from './NhChapterSlice/Ch1V30GM11_20';
import Ch1V30GM21_30 from './NhChapterSlice/Ch1V30GM21_30';
import Ch1V30GM31_40 from './NhChapterSlice/Ch1V30GM31_40';
import Ch1V30GM41_50 from './NhChapterSlice/Ch1V30GM41_50';
import Ch1V30GM51_60 from './NhChapterSlice/Ch1V30GM51_60';
import Ch1V30GM61_68 from './NhChapterSlice/Ch1V30GM61_68';
import Ch2V30GM1_10 from './NhChapterSlice/Ch2V30GM1_10';
import Ch2V30GM11_20 from './NhChapterSlice/Ch2V30GM11_20';
import Ch2V30GM21_30 from './NhChapterSlice/Ch2V30GM21_30';
import Ch2V30GM31_40 from './NhChapterSlice/Ch2V30GM31_40';
import Ch2V30GM41_50 from './NhChapterSlice/Ch2V30GM41_50';
import Ch2V30GM51_60 from './NhChapterSlice/Ch2V30GM51_60';
import Ch2V30GM61_68 from './NhChapterSlice/Ch2V30GM61_68';
import Ch3V30GM1_10 from './NhChapterSlice/Ch3V30GM1_10';
import Ch3V30GM11_20 from './NhChapterSlice/Ch3V30GM11_20';
import Ch3V30GM21_30 from './NhChapterSlice/Ch3V30GM21_30';
import Ch3V30GM31_40 from './NhChapterSlice/Ch3V30GM31_40';
import Ch3V30GM41_50 from './NhChapterSlice/Ch3V30GM41_50';
import Ch3V30GM51_60 from './NhChapterSlice/Ch3V30GM51_60';
import Ch3V30GM61_65 from './NhChapterSlice/Ch3V30GM61_65';
import Ch4V30GM1_10 from './NhChapterSlice/Ch4V30GM1_10';
import Ch4V30GM11_20 from './NhChapterSlice/Ch4V30GM11_20';
import Ch4V30GM21_30 from './NhChapterSlice/Ch4V30GM21_30';
import Ch4V30GM31_40 from './NhChapterSlice/Ch4V30GM31_40';
import Ch4V30GM41_50 from './NhChapterSlice/Ch4V30GM41_50';
import Ch4V30GM51_60 from './NhChapterSlice/Ch4V30GM51_60';
import Ch4V30GM61_70 from './NhChapterSlice/Ch4V30GM61_70';
import Ch4V30GM71_80 from './NhChapterSlice/Ch4V30GM71_80';
import Ch5V30GM1_10 from './NhChapterSlice/Ch5V30GM1_10';
import Ch5V30GM11_20 from './NhChapterSlice/Ch5V30GM11_20';
import Ch5V30GM21_30 from './NhChapterSlice/Ch5V30GM21_30';
import Ch5V30GM31_40 from './NhChapterSlice/Ch5V30GM31_40';
import Ch5V30GM41_50 from './NhChapterSlice/Ch5V30GM41_50';
import Ch5V30GM51_60 from './NhChapterSlice/Ch5V30GM51_60';
import Ch5V30GM61_70 from './NhChapterSlice/Ch5V30GM61_70';
import Ch5V30GM71_80 from './NhChapterSlice/Ch5V30GM71_80';
import Ch5V30GM81_89 from './NhChapterSlice/Ch5V30GM81_89';
import Ch6V30GM1_10 from './NhChapterSlice/Ch6V30GM1_10';
import Ch6V30GM11_20 from './NhChapterSlice/Ch6V30GM11_20';
import Ch6V30GM21_30 from './NhChapterSlice/Ch6V30GM21_30';
import Ch6V30GM31_40 from './NhChapterSlice/Ch6V30GM31_40';
import Ch6V30GM41_50 from './NhChapterSlice/Ch6V30GM41_50';
import Ch6V30GM51_60 from './NhChapterSlice/Ch6V30GM51_60';
import Ch6V30GM61_70 from './NhChapterSlice/Ch6V30GM61_70';
import Ch6V30GM71_80 from './NhChapterSlice/Ch6V30GM71_80';
import Ch6V30GM81_90 from './NhChapterSlice/Ch6V30GM81_90';
import Ch6V30GM91_100 from './NhChapterSlice/Ch6V30GM91_100';
import Ch6V30GM101_110 from './NhChapterSlice/Ch6V30GM101_110';
import Ch6V30GM111_120 from './NhChapterSlice/Ch6V30GM111_120';
import Ch6V30GM121_130 from './NhChapterSlice/Ch6V30GM121_130';
import Ch6V30GM131_139 from './NhChapterSlice/Ch6V30GM131_139';
const appRouter=createBrowserRouter([{
  path:"/",
  element:<Body/>,
  children:[
    {
      path:"/",
      element:<NewCardContainer/>
    },
      {
        path:'/',
        element:<Body/>

      },
      {
        path:'/ch1vol30',
        element:<Ch1Vol30/>
      },
      {
        path:'/ch2vol30',
        element:<Ch2Vol30/>
      },
      {
        path:'/ch3vol30',
        element:<Ch3Vol30/>
      }, {
        path:'/ch4vol30',
        element:<Ch4Vol30/>
      },
      {
        path:'/ch5vol30',
        element:<Ch5Vol30/>
      },
      {
        path:'/ch6vol30',
        element:<Ch6Vol30/>
      },
      {
        path:'/ch1V30GM1_10',
        element:<Ch1V30GM1_10/>
      },
      {
        path:'/ch1V30GM11_20',
        element:<Ch1V30GM11_20/>
      },
      {
        path:'/ch1V30GM21_30',
        element:<Ch1V30GM21_30 />
      },
      {
        path:'/ch1V30GM31_40',
        element:<Ch1V30GM31_40/>
      },
      {
        path:'/ch1V30GM41_50',
        element:<Ch1V30GM41_50/>
      },
      {
        path:'/ch1V30GM51_60',
        element:<Ch1V30GM51_60 />
      },
      {
        path:'/ch1V30GM61_68',
        element:<Ch1V30GM61_68 />
      },
      {
        path:'/ch2V30GM1_10',
        element:<Ch2V30GM1_10 />
      },
      {
        path:'/ch2V30GM11_20',
        element:<Ch2V30GM11_20 />
      },
      {
        path:'/ch2V30GM21_30',
        element:<Ch2V30GM21_30 />
      },
      {
        path:'/ch2V30GM31_40',
        element:<Ch2V30GM31_40 />
      },
      {
        path:'/ch2V30GM41_50',
        element:<Ch2V30GM41_50 />
      },
      {
        path:'/ch2V30GM51_60',
        element:<Ch2V30GM51_60 />
      },
      {
        path:'/ch2V30GM61_68',
        element:<Ch2V30GM61_68 />
      },
      {
        path:'/ch3V30GM1_10',
        element:<Ch3V30GM1_10 />
      },
      {
        path:'/ch3V30GM11_20',
        element:<Ch3V30GM11_20 />
      },
      {
        path:'/ch3V30GM21_30',
        element:<Ch3V30GM21_30 />
      },
      {
        path:'/ch3V30GM31_40',
        element:<Ch3V30GM31_40 />
      },
      {
        path:'/ch3V30GM41_50',
        element:<Ch3V30GM41_50 />
      },
      {
        path:'/ch3V30GM51_60',
        element:<Ch3V30GM51_60 />
      },
      {
        path:'/ch3V30GM61_65',
        element:<Ch3V30GM61_65 />
      },
      {
        path:'/ch4V30GM1_10',
        element:<Ch4V30GM1_10 />
      },
      {
        path:'/ch4V30GM11_20',
        element:<Ch4V30GM11_20 />
      },
      {
        path:'/ch4V30GM21_30',
        element:<Ch4V30GM21_30 />
      },
      {
        path:'/ch4V30GM31_40',
        element:<Ch4V30GM31_40 />
      },
      {
        path:'/ch4V30GM41_50',
        element:<Ch4V30GM41_50 />
      },
      {
        path:'/ch4V30GM51_60',
        element:<Ch4V30GM51_60 />
      },
      {
        path:'/ch4V30GM61_70',
        element:<Ch4V30GM61_70 />
      },
      {
        path:'/ch4V30GM71_80',
        element:<Ch4V30GM71_80 />
      },
      {
        path:'/ch5V30GM1_10',
        element:<Ch5V30GM1_10 />
      },
      {
        path:'/ch5V30GM11_20',
        element:<Ch5V30GM11_20 />
      },
      {
        path:'/ch5V30GM21_30',
        element:<Ch5V30GM21_30 />
      },
      {
        path:'/ch5V30GM31_40',
        element:<Ch5V30GM31_40 />
      },
      {
        path:'/ch5V30GM41_50',
        element:<Ch5V30GM41_50 />
      },
      {
        path:'/ch5V30GM51_60',
        element:<Ch5V30GM51_60 />
      },
      {
        path:'/ch5V30GM61_70',
        element:<Ch5V30GM61_70 />
      },
      {
        path:'/ch5V30GM71_80',
        element:<Ch5V30GM71_80 />
      },
      {
        path:'/ch5V30GM81_89',
        element:<Ch5V30GM81_89 />
      },
      {
        path:'/ch6V30GM1_10',
        element:<Ch6V30GM1_10 />
      },
      {
        path:'/ch6V30GM11_20',
        element:<Ch6V30GM11_20 />
      },
      {
        path:'/ch6V30GM21_30',
        element:<Ch6V30GM21_30 />
      },
      {
        path:'/ch6V30GM31_40',
        element:<Ch6V30GM31_40 />
      },
      {
        path:'/ch6V30GM41_50',
        element:<Ch6V30GM41_50 />
      },
      {
        path:'/ch6V30GM51_60',
        element:<Ch6V30GM51_60 />
      },
      {
        path:'/ch6V30GM61_70',
        element:<Ch6V30GM61_70 />
      },
      {
        path:'/ch6V30GM71_80',
        element:<Ch6V30GM71_80 />
      },
      {
        path:'/ch6V30GM91_100',
        element:<Ch6V30GM91_100 />
      },
      {
        path:'/ch6V30GM101_110',
        element:<Ch6V30GM101_110 />
      },
      {
        path:'/ch6V30GM111_120',
        element:<Ch6V30GM111_120 />
      },
      {
        path:'/ch6V30GM121_130',
        element:<Ch6V30GM121_130 />
      },
      {
        path:'/ch6V30GM131_139',
        element:<Ch6V30GM131_139 />
      }
  ]

}])
function App() {
  return (
   
    <div>
    <Header/>
    <RouterProvider router={appRouter}/>
    </div>
  );
}

export default App;



