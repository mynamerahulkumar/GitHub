
import { render ,screen,fireEvent} from "@testing-library/react"
import { Provider } from "react-redux";
import "@testing-library/jest-dom";
import RestaurantCard from "../components/RestaurantCard";
import MOCK_DATA from "../mocks/restCartMock.json"

it("should render restaurant card component with props data",()=>{
    render(<RestaurantCard resData={MOCK_DATA}/>);
    const name=screen.getByText("Biryani");

    expect(name).toBeInTheDocument();
}

)
