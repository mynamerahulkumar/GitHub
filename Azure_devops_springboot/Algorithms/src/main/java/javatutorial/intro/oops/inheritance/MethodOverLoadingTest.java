package javatutorial.intro.oops.inheritance;

public class MethodOverLoadingTest {
    // two parameter passed
    public int getAdd(int a,int b){
        int s=a+b;
        return s;
    }
    // three parameter passed
    public int getAdd(int a,int b,int c){
        int s=a+b+c;
        return s;
    }

    public static void main(String[] args) {
        MethodOverLoadingTest object=new MethodOverLoadingTest();
        int res=object.getAdd(2,3);
        System.out.println(res);//5
        int res2=object.getAdd(2,3,4);
        System.out.println(res2);//9

    }
}
