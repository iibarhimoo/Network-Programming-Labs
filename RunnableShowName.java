package org.Ibrahim;

public class RunnableShowName implements Runnable{
    public static void main(String[] args) {

        RunnableShowName runnable1 = new RunnableShowName();
        RunnableShowName runnable2 = new RunnableShowName();
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);


        thread1.start();
        thread1.start();

    }
    public void run () {
            int pause;
            for (int i = 0; i < 10; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + "being executed");
                    Thread.sleep(2000);
                } catch (InterruptedException intrruptEx) {
                    System.out.println(intrruptEx);
                }
            }
        }
}
