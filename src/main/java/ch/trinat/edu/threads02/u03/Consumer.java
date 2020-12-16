package ch.trinat.edu.threads02.u03;

public class Consumer extends Thread{
    BufferN buffer;

    Consumer (BufferN buffer) {
        this.buffer = buffer;
    }

    public void run() {
        while(true) {
            System.out.println("get " + Thread.currentThread().getName() + " - " + buffer.get());
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
