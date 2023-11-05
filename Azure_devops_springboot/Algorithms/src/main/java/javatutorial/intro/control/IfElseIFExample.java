package javatutorial.intro.control;

public class IfElseIFExample {
    public static void main(String[] args) {
        int score=74;
        if(score<50){
            System.out.println("fail");
        }
        else if(score>=50 && score<60){
            System.out.println("D grade");
        }
        else if(score>=60 && score<70){
            System.out.println("C grade");
        }
        else if(score>=70 && score<85){
            System.out.println("B grade");
        }
        else if(score>=85 && score<100){
            System.out.println("A grade");
        }else{
            System.out.println("Invalid!");
        }

    }
}
