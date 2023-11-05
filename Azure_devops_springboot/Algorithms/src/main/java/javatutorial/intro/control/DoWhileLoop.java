package javatutorial.intro.control;

public class DoWhileLoop {
    /**
     * do while loop-it will run first inside code and then check condition
     * @param args
     */
    public static void main(String[] args) {
        int i=1;
        do{
            System.out.println(i);// 1 2 3 4 5 6 7 8 9 10
            i++;
        }while (i<=10);
    }
}
