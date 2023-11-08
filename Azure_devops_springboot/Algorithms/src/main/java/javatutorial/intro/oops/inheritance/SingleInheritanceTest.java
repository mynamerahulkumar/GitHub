package javatutorial.intro.oops.inheritance;

class Animal{
    void eat(){
        System.out.println("I am eating ");
    }
}
class Dog extends Animal{
    void bark(){
        System.out.println("Puppy is barking");
    }
}
public class SingleInheritanceTest {
    public static void main(String[] args) {
        Dog dog=new Dog();
        dog.bark();
       // Puppy is barking
        dog.eat();
        //
    }
}
