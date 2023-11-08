package javatutorial.intro.oops.inheritance;


class Dogs {
    public void eat() {
        System.out.println("Animals are eating ");
    }
}
class Puppys extends Dogs{
    public void eat(){
        System.out.println("Puppys are eating ");
    }
}

public class MethodOverridingTest {

    public static void main(String[] args) {
        Puppys puppys=new Puppys();
        puppys.eat();//Puppys are eating
        Dogs dogs=new Dogs();//Animals are eating
        dogs.eat();
    }
}
