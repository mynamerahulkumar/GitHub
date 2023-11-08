package javatutorial.intro.oops.inheritance;
class Animal2{
    void eat(){
        System.out.println("I am eating");
    }
}class  Dog2 extends Animal2{
    void  bark(){
        System.out.println("Puppy is barking");
    }
}class Rabbit extends Animal2{
    void run(){
        System.out.println("Rabbit is running in circle");
    }
}public class HierarchicalInheritanceTest {
    public static void main(String[] args) {
        Rabbit rabbit=new Rabbit();
        rabbit.run();
        //Rabbit is running in circle
        rabbit.eat();
        //Rabbit is running in circle
       // rabbit.bark(); this will give error
        Dog2 dog=new Dog2();
        dog.bark();
        dog.eat();

    }
}
