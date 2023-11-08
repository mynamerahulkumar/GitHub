package javatutorial.intro.oops.inheritance;

public class MethodOverLoadingTest2 {
    // two parameter passed
    public int getAdd(int a,int b){
        int s=a+b;
        return s;
    }
    // three parameter passed
    public double getAdd(double a,double b){
        double s=a+b;
        return s;
    }

    public static void main(String[] args) {
        MethodOverLoadingTest2 object=new MethodOverLoadingTest2();
        int res=object.getAdd(2,3);
        System.out.println(res);//5
        double res2=object.getAdd(2.5,3);
        System.out.println(res2);//5.5

    }
}
