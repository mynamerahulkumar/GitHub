import { render,screen ,fireEvent} from "@testing-library/react"
import Body from "../components/body"
import MOCK_DATA from "../mocks/BodyRestMock.json"
import { act } from "react-dom/test-utils"
import { BrowserRouter } from "react-router-dom"
global.fetch=jest.fn(()=>{
    return Promise.resolve(
        {
            json:()=>{
                return Promise.resolve(MOCK_DATA;
            }
        }
    )
}

)

it("Should render the Body component with Search", async()=>{
        await act (async()=>{
            render(
                <BrowserRouter>
                 <Body/>
                </BrowserRouter>
            )
        });

        const searchInput=screen.getByTestId("searchInput");
        fireEvent.change(searchInput,{target:{value:"burger"}})
        fireEvent.click(searchInput);
        expect(searchInput).toBeInTheDocument();
    
}
)
it("Should render the Body component with top ratedSearch", async()=>{
    await act (async()=>{
        render(
            <BrowserRouter>
             <Body/>
            </BrowserRouter>
        )
    });

   const CardBeforFilter=screen.getAllByTestId("resCard");
   expect(CardBeforFilter.length).toBe(20);

   const topRatedBtn=screen.getByRole("button",{name:"Top Rated Restaurants"});

   fireEvent.click(topRatedBtn);

   const cardAfterClick=screen.getAllByTestId("resCard");

   expect(cardAfterClick.length).toBe(13);

}
)