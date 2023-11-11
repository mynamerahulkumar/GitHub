package javatutorial.intro.oops.inheritance;

public class AbstractExampleTest {
    abstract class Vehicle{
        int noWheel;
        String modelName;
        String companyName;
        public Vehicle(int noWheel,String modelName,String companyName){
            this.noWheel=noWheel;
            this.modelName=modelName;
            this.companyName=companyName;
        }
        public String  getModelName(){
            System.out.println("Model Name-"+this.modelName);
            return this.modelName;
        }
    }
    public static void main(String[] args) {
        AbstractExampleTest object=new AbstractExampleTest();
       // Vehicle vehicle=new Vehicle(6,"500D","VOLVO");
        //java: javatutorial.intro.oops.inheritance.AbstractExampleTest.Vehicle is abstract;
        // cannot be instantiated
    }

}
