package javatutorial.intro.exceptions;

public class JavaExceptionTest {
    public static void main(String[] args) {
        try{
            int data=100/0;
        }catch (ArithmeticException e){
            System.out.println("ArithmeticException ="+e);
            //ArithmeticException =java.lang.ArithmeticException: / by zero
        }
        finally {
            System.out.println("Close any existing connection");
            //Close any existing connection
        }
    }
}
