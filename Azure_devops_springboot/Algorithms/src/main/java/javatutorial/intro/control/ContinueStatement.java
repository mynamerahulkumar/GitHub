package javatutorial.intro.control;

public class ContinueStatement {
    /**
     * continue statement
     * @param args
     */
    public static void main(String[] args) {
        //for loop
        for(int i=1;i<=10;i++){
            if(i==5){
                //using continue statement
                continue;//it will skip the rest print statement// 1 2 3 4  6 7 8 9 10
            }
            System.out.println(i);
        }

    }
}
