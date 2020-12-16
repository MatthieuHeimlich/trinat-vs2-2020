package ch.trinat.edu.threads02.u03;

public class Producer extends Thread{
    BufferN buffer;
    int startValue;

    Producer(BufferN buffer, int startValue) {
        this.buffer = buffer;
        this.startValue = startValue;
        this.start();
    }

    public void run() {
        for(int i=startValue; i<100 + startValue; i++ ) {
            buffer.put(i);
            System.out.println("put " + Thread.currentThread().getName() + " " + i);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
