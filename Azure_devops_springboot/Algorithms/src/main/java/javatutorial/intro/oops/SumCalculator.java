package javatutorial.intro.oops;

public class SumCalculator {
    /**
     * It will calculate the value of a and b
     * @param a
     * @param b
     * @return
     */
    public int getSum(int a,int b){
        int c=a+b;
        return c;
    }
    public  void printSum(int a,int b){
        int c=a+b;
        System.out.println("Sum of "+ a+" and "+b+" = "+c);
        //Sum of 10 and 20 = 30

    }
    public static void main(String[] args) {
        SumCalculator calculator=new SumCalculator();
        int a=10;
        int b=20;
        calculator.printSum(a,b);
    }
}
