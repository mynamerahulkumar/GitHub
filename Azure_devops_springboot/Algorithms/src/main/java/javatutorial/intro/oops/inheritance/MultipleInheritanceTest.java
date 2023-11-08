package javatutorial.intro.oops.inheritance;

class Animal1{
    void eat(){
        System.out.println("I am eating");
    }
}class Dog1 extends Animal1{
    void bark(){
        System.out.println("Puppy is barking");
    }
}class BabyPuppy extends Dog1{
    void run(){
        System.out.println("Baby puppy is running");
    }
}
public class MultipleInheritanceTest {
    public static void main(String[] args) {
        BabyPuppy babyPuppy=new BabyPuppy();
        babyPuppy.run();
        //Baby puppy is running
        babyPuppy.bark();
        //Puppy is barking
        babyPuppy.eat();
        //I am eating

    }
}
