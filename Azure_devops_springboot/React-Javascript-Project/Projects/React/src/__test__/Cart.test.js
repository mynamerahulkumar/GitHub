import { fireEvent, render ,screen} from "@testing-library/react"
import { act } from "react-dom/test-utils"
import MOCK_DATA from "../mocks/MenuRestMock.json"
import { Provider } from "react-redux"
import appStore from "../utils/appStore"
import Header from "../components/Header"
import { BrowserRouter } from "react-router-dom"
import "@testing-library/jest-dom"
import Cart from "../components/Cart"
global.fetch =jest.fn(()=>{
    return Promise.resolve({
        json:()=>Promise.resolve(MOCK_DATA)
    })
})
it("should load resutant menu component",async()=>{
    await act(async()=>render(
        <BrowserRouter>
        <Provider store={appStore}>
            <Header/>
            <Cart/>
            <RestaurantM/>
        </Provider>
        </BrowserRouter>

    ));
    
    const accordionHeader=screen.getByText("Biryani");
    fireEvent.click(accordionHeader);

    expect(screen.getAllByTestId("foodItems").length).toBe(5);

    const addBtn=screen.getAllByRole("button",{name:"Add +"});
    fireEvent.click(addBtn[0]);
    expect(screen.getByText("Cart(1-items)")).toBeInTheDocument();
    fireEvent.click(addBtn[1]);
    expect(screen.getByText("Cart(1-items)")).toBeInTheDocument();

    fireEvent.click(screen.getByRole("button").length).toBe(5);

    expect(screen.getByText("Cart is Empty")).toBeInTheDocument();



})