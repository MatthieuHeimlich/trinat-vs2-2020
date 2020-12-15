package ch.trinat.edu.threads01.u03.punkt2;

public class MeinRunnable2 implements Runnable {
    @Override
    public void run() {
        System.out.println("Start mein Runnabble");
        los();
    }
    private void los() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tuNochMehr();
    }
    private void tuNochMehr() {
        System.out.println("Oben auf den Stack");
    }
}
