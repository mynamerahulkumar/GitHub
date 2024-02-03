const { default: Sum } = require("../components/Sum")


test("Sum function should calculate sum of two number",()=>{
    const result=Sum(3,5);
    expect(result).toBe(8);
})