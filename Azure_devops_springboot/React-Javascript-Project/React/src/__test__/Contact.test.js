import Contact from "../components/Contact"
import {render,screen} from '@testing-library/react';
import "@testing-library/jest-dom";

describe("These are Contact us test cases",()=>{

    beforAll(()=>{
        console.log("Before All");
    })
    it("Should Load heading component",()=>{
        render(<Contact/>);
        const heading = screen.getByRole('heading')
    
        expect(heading).toBeInTheDocument();
    
    });
    
    test("should load placeholder name",()=>{
        render(<Contact/>);
    
        const inputName=screen.getByPlaceholderText("name");
    
        expect(inputName).toBeInTheDocument();
    })
    
    test("Should Load2 input boxed",()=>{
        render(<Contact/>);
    
        const inputBoxes=screen.getAllByRole('textbox');
    
        expect(inputBoxes.length).toBe(2);
    
    
    });
}
);

