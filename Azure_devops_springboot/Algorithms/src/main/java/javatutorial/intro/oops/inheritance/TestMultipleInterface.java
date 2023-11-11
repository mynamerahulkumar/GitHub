package javatutorial.intro.oops.inheritance;
interface Printable{
    void print();
}
interface Showable{
    void show();
}
class A7 implements Printable,Showable {
    public void print() {
        System.out.println("Hello");
    }
    public void show() {
        System.out.println("Welcome");
    }
}
    public class TestMultipleInterface {
        public static void main(String[] args) {
            A7 obj = new A7();
            obj.print();//Hello
            obj.show();//Welcome
        }
    }

