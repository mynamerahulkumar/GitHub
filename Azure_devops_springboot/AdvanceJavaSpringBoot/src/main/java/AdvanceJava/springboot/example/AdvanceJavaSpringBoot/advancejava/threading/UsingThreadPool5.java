package AdvanceJava.springboot.example.AdvanceJavaSpringBoot.advancejava.threading;

import java.util.concurrent.*;

public class UsingThreadPool5 {
    public static void main(String[] args) throws InterruptedException {

        ThreadPoolExecutor tpl=new ThreadPoolExecutor(5,5,1, TimeUnit.SECONDS,
                /**
                 * if value=5, 5 thread will be processing 5 task and max 5task  in queue if 6th task comes
                 * while processing then it will throw then we can catch and execute again
                 */
                new ArrayBlockingQueue<>(20),
                new ThreadFactory(){
                    final String threadName="rahul-kumar-";
                    int count=0;
                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread(threadName+"-"+count);
                    }
                });

        Runnable printThreadName=()->{
            for(int i=0;i<5;i++){
                System.out.println("count-"+i+" "+Thread.currentThread().getName());
            }
        };
//        for(int i=0;i<20;i++){
//            tpl.execute(printThreadName);
//        }
        for(int i=0;i<20;i++){
            try {
                tpl.execute(printThreadName);
            }
            catch (RejectedExecutionException e){
                Thread.sleep(200);
                tpl.execute(printThreadName);
            }
        }
        tpl.shutdown();
    }
}
