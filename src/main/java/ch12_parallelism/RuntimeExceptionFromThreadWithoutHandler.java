package ch12_parallelism;

public class RuntimeExceptionFromThreadWithoutHandler {
    public static void main(String[] args) throws InterruptedException {
        Thread.currentThread().setName("thread-0");

        Thread thread1 = new Thread(() -> {
            throw new RuntimeException("Oh no! Exception!");
        });

        thread1.setName("thread-1");
        thread1.start();

        Thread.sleep(100);
        System.out.println("Finishing " + Thread.currentThread().getName());
    }

}
