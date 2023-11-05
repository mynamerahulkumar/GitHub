package javatutorial.intro.control;

public class NestedIfStatement {
    public static void main(String[] args) {
        int age=20;
        int marks=85;
        if(age>18){
            if(marks>80){
                System.out.println("You are qualified");// it will run
            }
        }
    }
}
