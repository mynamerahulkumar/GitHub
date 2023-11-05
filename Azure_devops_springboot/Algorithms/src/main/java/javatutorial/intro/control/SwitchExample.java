package javatutorial.intro.control;

public class SwitchExample {
    /**
     * switch statement
     * @param args
     */
    public static void main(String[] args) {
        char grade='B';
        switch (grade){
            case 'A' :
                System.out.println("Awesome!");
                break;
            case 'B' :
            case 'C' :
                System.out.println("Very Good");// this will run
                break;
            case 'D' :
                System.out.println("You passed");
            case 'F' :
                System.out.println("Better try again");
                break;
            default :
                System.out.println("Invalid grade");
        }
        System.out.println("Your grade is " + grade);

    }
}
