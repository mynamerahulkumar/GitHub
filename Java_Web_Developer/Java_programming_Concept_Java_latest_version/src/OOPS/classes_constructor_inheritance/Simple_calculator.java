package OOPS.classes_constructor_inheritance;

public class Simple_calculator {
    public Double firstNumber;
    public Double secondNumber;

    public Double getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(Double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public Double getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(Double secondNumber) {
        this.secondNumber = secondNumber;
    }
    public Double getAddition(){
        return this.firstNumber+this.secondNumber;
    }
    public Double getSubtraction(){
        return this.firstNumber+this.secondNumber;
    }
    public Double getMultiplication(){
        return this.firstNumber-this.secondNumber;
    }
    public Double getDivision(){
        if(this.secondNumber==0){
            return 0.0;
        }
        return this.firstNumber/this.secondNumber;
    }

}
