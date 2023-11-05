package javatutorial.intro.control;

public class LogicalOperator {
    public static void main(String[] args) {
        int a=10;
        int b=20;
        int c=30;
        System.out.println(c>b && c>a);//true
        System.out.println(b<c || a>b);//true
        // find the min between a and b
        int min=a>b?b:a;
        System.out.println("min="+min);//10
    }
}
