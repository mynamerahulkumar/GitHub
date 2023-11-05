package javatutorial.intro.oops;

public class ExampleOverLoading {
    // for integer
    public  int getSum(int a,int b){
        int c=a+b;
        return c;
    }
    // for double
    public double getSum(double a,double b){
        double c=a+b;
        return c;
    }
    public static void main(String[] args) {
        ExampleOverLoading example=new ExampleOverLoading();
        int i=10;
        int j=20;
        int result=example.getSum(i,j);
        System.out.println("Sum value="+result);
        //Sum value=30
        double a=10.0;
        double b=35.0;
        double result2=example.getSum(a,b);
        System.out.println("Sum value="+result2);
        //Sum value=45.0
    }
}
