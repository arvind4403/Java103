import java.util.Random;

public class RunningRace {
    public static void main(String[] args) {
        Runner runner1 = new Runner("Runner 1");
        Runner runner2 = new Runner("Runner 2");
        Runner runner3 = new Runner("Runner 3");

        Thread thread1 = new Thread(runner1);
        Thread thread2 = new Thread(runner2);
        Thread thread3 = new Thread(runner3);

        thread1.start();
        thread2.start();
        thread3.start();

        while (true) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(runner1.getName()+": " + runner1.getDistance() + " meter");
            System.out.println(runner2.getName()+ ": " + runner2.getDistance()+ " meter");
            System.out.println(runner3.getName()+": " + runner3.getDistance()+ " meter");

            if (runner1.getDistance() >= 100 || runner2.getDistance() >= 100 || runner3.getDistance() >= 100) {
                if (runner1.getDistance() >= 100) {
                    System.out.println(runner1.getName() + " wins!");
                } else if (runner2.getDistance() >= 100) {
                    System.out.println(runner2.getName() + " wins!");
                } else {
                    System.out.println(runner3.getName() + " wins!");
                }
                break;
            }
        }
    }
}

class Runner implements Runnable {
    private String name;
    private int distance;

    public Runner(String name) {
        this.name = name;
        this.distance = 0;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (distance < 100) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            distance += random.nextInt(10) + 1;
        }
    }
}
