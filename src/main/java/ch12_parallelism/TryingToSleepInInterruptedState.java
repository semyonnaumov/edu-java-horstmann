package ch12_parallelism;

public class TryingToSleepInInterruptedState {
    public static void main(String[] args) throws InterruptedException {
        Thread.currentThread().setName("thread-0");

        Thread thread1 = new Thread(() -> {
            Thread thisThread = Thread.currentThread();

            // interrupting the thread to see the flag
            thisThread.interrupt();
            System.out.println(thisThread.getName() + ", interrupted = " + thisThread.isInterrupted());

            try {
                // immediately throws the exception, resets the flag to false
                thisThread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught, interrupted = " + thisThread.isInterrupted());
            }
        });

        thread1.setName("thread-1");
        thread1.start();
    }
}
