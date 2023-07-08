 class MyTask implements Runnable {
    @Override
    public void run(){
        try {
            Thread.sleep(1);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Executing myTask in separate thread ");
    }

}

public class Runnable1 {
    public static void main(String[] args ){
        MyTask myTask=new MyTask();

        Thread thread=new Thread(myTask);
        thread.start();
        try {
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Executing main thread ");


    }
}
