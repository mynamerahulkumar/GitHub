package javatutorial.intro.oops.inheritance;

interface  Design{
    String getModelDesignName();
}
class Factory implements Design{

    @Override
    public String getModelDesignName() {
        return "D500DX";
    }
    public void printFactoryName(){
        System.out.println("Welcome to MARDC");
    }
}
public class TestInterface {
    public static void main(String[] args) {
        Factory factory=new Factory();
       String modelDesign= factory.getModelDesignName();
        System.out.println("Model Design-"+modelDesign);
        //Model Design-D500DX
        factory.printFactoryName();
        //Welcome to MARDC
    }
}
