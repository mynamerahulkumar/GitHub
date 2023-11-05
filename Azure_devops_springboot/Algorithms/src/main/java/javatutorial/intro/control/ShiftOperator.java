package javatutorial.intro.control;

public class ShiftOperator {
    /**
     * The Java left shift operator << is used to shift all of the bits in a value to the left side
     * of a specified number of times.
     * The Java right shift operator >> is used to move the value of the left operand to right
     * by the number of bits specified by the right operand.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(10<<2);//10*2^2=10*4=40
        System.out.println(10>>2);//10/2^2=10/4=2


    }
}
