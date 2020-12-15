package ch.trinat.edu.threads01.u03.punkt1;

public class ThreadTestLauf1 {
    public static void main(String[] args) {
        Runnable threadJob = new MeinRunnable1();
        Thread meinThread = new Thread(threadJob);
        meinThread.start();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("zurück in main");
    }
}