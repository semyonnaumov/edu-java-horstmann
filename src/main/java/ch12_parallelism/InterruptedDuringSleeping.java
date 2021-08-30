package ch12_parallelism;

public class InterruptedDuringSleeping {

    public static void main(String[] args) throws InterruptedException {
        Thread.currentThread().setName("thread-0");

        Thread thread1 = new Thread(() -> {
            Thread thisThread = Thread.currentThread();

            for (int i = 0; i < 10; i++) {
                try {
                    System.out.println(thisThread.getName() + ", i = " + i + ", interrupted = " + thisThread.isInterrupted());
                    thisThread.sleep(100);
                } catch (InterruptedException e) {
                    // here interrupted is false since throwing InterruptedException resets the flag to false!
                    System.out.println("InterruptedException caught, interrupted = " + thisThread.isInterrupted());
                }
            }
        });

        thread1.setName("thread-1");
        thread1.start();

        Thread.sleep(350);
        System.out.println(Thread.currentThread().getName() + " interrupts " + thread1.getName());
        thread1.interrupt();
    }
}
