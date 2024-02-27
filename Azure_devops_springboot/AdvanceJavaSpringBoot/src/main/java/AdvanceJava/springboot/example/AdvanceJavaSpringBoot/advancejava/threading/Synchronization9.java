package AdvanceJava.springboot.example.AdvanceJavaSpringBoot.advancejava.threading;

public class Synchronization9 {
    static class SyncTask{
        int id;
        public SyncTask(int id){
            this.id=id;
        }
        synchronized  void synctask1(){
            System.out.println(Thread.currentThread().getName()+"id-"+id+"-start1");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+"id-"+id+"-end1");
        }
        synchronized void synctask2(){
            System.out.println(Thread.currentThread().getName()+"id-"+id+"-start2");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+"id-"+id+"-end2");
        }
        void doTask(){
            Thread t1=new Thread(this::synctask1);
            Thread t2=new Thread(this::synctask2);
            t1.start();
            t2.start();
        }

    }

    public static void main(String[] args) {
        SyncTask syncTask1=new SyncTask(1);
        SyncTask syncTask2=new SyncTask(2);
        /**
         * t1 and t2 will run one by one for object syn1
         * t1 and t2 will run one by one for object sync2
         * here both sync1 and sync2 object will run parallely for t1 and then for t2
         */
        syncTask1.doTask();
        syncTask2.doTask();
    }
}
