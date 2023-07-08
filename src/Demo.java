class A extends Thread  {
    public void run() {
        for (int i = 1; i < 10; i++) {
            System.out.println("hi..");
        }
        try {
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}

class B extends Thread {
    public void run() {
        for (int i = 1; i < 10; i++) {
            System.out.println("Hello...");
        }
        try {
            Thread.sleep(50);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
public class Demo{
    public static void main(String[] args){
        A obj1=new A();
        B obj2=new B();

        obj1.start();
        obj2.start();
    }

}

//public class Demo{
//    public static void main(String[] args){
//        Thread thread1=new Thread("Thread1");
//        Thread thread2=new Thread("Thread2");
//
//        thread1.start();
//        thread2.start();
//
//        for (int i=0; i<10; i++){
//            System.out.println("Main Thread : "+ i);
//            try {
//                Thread.sleep(1000);
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//        }
//    }
//    static class MyThread extends Thread{
//        private String name;
//        public MyThread(String name){
//            this.name=name;
//        }
//        @Override
//        public void run(){
//            for (int i=0; i<5; i++){
//                System.out.println("name : " +i);
//            }
//            try {
//                Thread.sleep(1000);
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//        }
//    }
//
//}