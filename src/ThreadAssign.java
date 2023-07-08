class Printer{
    private boolean isOddPrinted= false;

    public synchronized void printOdd(int number){
        while (isOddPrinted){
            try {
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("ThreadA :"+number);
        isOddPrinted=true;
        notify();
    }
    public synchronized void printEven(int number){
        while (!isOddPrinted){
            try {
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("ThreadB : "+number);
        isOddPrinted=false;
        notify();
    }
}

class ThreadA implements Runnable{
    private final Printer printer;
    public ThreadA(Printer printer){
        this.printer=printer;
    }
    @Override
    public void run(){
        for (int i=1; i<=9; i+=2){
            printer.printOdd(i);
        }
    }
}
class ThreadB implements Runnable{
    private final Printer printer;
    public ThreadB(Printer printer){
        this.printer=printer;
    }
    @Override
    public void run(){
        for (int i=2; i<=10; i+=2){
            printer.printEven(i);
        }
    }
}
public class ThreadAssign{
    public static void main(String[] args){
        Printer printer=new Printer();
        ThreadA threadA=new ThreadA(printer);
        ThreadB threadB=new ThreadB(printer);

        Thread t1=new Thread(threadA);
        Thread t2=new Thread(threadB);

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}