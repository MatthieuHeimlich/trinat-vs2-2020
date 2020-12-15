package ch.trinat.edu.threads01.u10;

public class StopThreadByInterrupt extends Thread {
    private boolean stopped = false;

    public StopThreadByInterrupt() {
        start();
    }

    public synchronized void stopThread() {
        stopped = true;
    }

    public synchronized boolean isStopped() {
        return stopped;
    }

    public void run() {
        int i = 0;
        while (!isStopped()) {
            i++;
            System.out.println("Hallo Welt (" + i + ")");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("Interrupt bekommen !");
                stopThread();
            }
        }
        System.out.println("Thread endet jetzt...");
    }

    public static void main(String[] args) {
        StopThreadByInterrupt st = new StopThreadByInterrupt();

        try {
            Thread.sleep(9100);
        } catch (InterruptedException e) {

        }
        System.out.println("Main task slepp over");
        st.stopThread();
        System.out.println("Main task ends now");
    }
}