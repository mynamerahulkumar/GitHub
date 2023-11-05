package javatutorial.intro.oops.inheritance;

class Employee{
    float salary=4000;
}
public class Programmer extends Employee {
    int bonus=1000;

    public static void main(String[] args) {
        Programmer programmer=new Programmer();
        System.out.println("Employee salary-"+programmer.salary);
        //Employee salary-4000.0
        System.out.println("Programmer bonus-"+programmer.bonus);
        //Programmer bonus-1000
    }
}
