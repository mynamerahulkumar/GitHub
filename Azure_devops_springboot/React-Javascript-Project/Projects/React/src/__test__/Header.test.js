import { render ,screen,fireEvent} from "@testing-library/react"
import Header from "../components/Header"
import { Provider } from "react-redux";
import appStore from "../utils/appStore";
import "@testing-library/jest-dom";

import { BrowserRouter } from "react-router-dom";
//provide redux store to header
it("Shuoul load heaer component with a login button",()=>{
    render(
        <BrowserRouter>
            <Provider store={appStore}
        ><Header/>
        </Provider>
        </BrowserRouter>
        
    );
    const loginButton=screen.getByRole("button",{name:"Login"});
    const loginText=screen.getByText("Login");
    expect(loginText).toBeInTheDocument();
    expect(loginButton).toBeInTheDocument();
})

it("Shuoul load cart  component with a login button",()=>{
    render(
        <BrowserRouter>
            <Provider store={appStore}
        ><Header/>
        </Provider>
        </BrowserRouter>
        
    );
    
    const loginText=screen.getByText(/Cart/);
    expect(loginText).toBeInTheDocument();
})

it("Shuoul change  login button to logout button ",()=>{
    render(
        <BrowserRouter>
            <Provider store={appStore}
        ><Header/>
        </Provider>
        </BrowserRouter>
        
    );
    
    const loginButton=screen.getByRole("button",{name:"Login"});
    fireEvent.click(loginButton);
    const logOutButton=screen.getByRole("button",{name:'Logout'})

    expect(logOutButton).toBeInTheDocument();
})
