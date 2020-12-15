package ch.trinat.edu.threads01.u03.punkt2;

public class ThreadTestLauf2 {
    public static void main(String[] args) {
        Runnable threadJob = new MeinRunnable2();
        Thread meinThread = new Thread(threadJob);
        meinThread.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("zurück in main");
    }
}