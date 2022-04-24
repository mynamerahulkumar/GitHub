package basics;

public class TestBreak {
    public static void main(String[] args) {
        int key=25;
        for(int i=0;i<=1000000;i++){
            if(key==i){
                System.out.println("Key found");
                break;
            }
            else{
                System.out.println("Key not found");
            }
        }
    }
    System.out.println("Code complete");
    }
}
