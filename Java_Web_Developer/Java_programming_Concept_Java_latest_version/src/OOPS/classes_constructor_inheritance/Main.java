package OOPS.classes_constructor_inheritance;

public class Main {
    public static void main(String[] args) {
        Simple_calculator calculator=new Simple_calculator();
        calculator.setSecondNumber(4.0);
        calculator.setFirstNumber(5.0);
        System.out.println("add-"+calculator.getAddition());

    }
}
