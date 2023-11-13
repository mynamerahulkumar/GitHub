package javatutorial.intro.multithread;

class PrintDemo{
    public void printCountNum(){
        try{
            for(int i=0;i<5;i++){
                System.out.println("Counter-"+i);
            }
        }
        catch (Exception e){
            System.out.println("Thread interrupted-"+e);
        }
    }
}
class ThreadExample extends Thread{

        }
public class TestThread {
    public static void main(String[] args) {

    }
}
