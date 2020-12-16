package ch.trinat.edu.threads02.u03;

public class ProducerConsumer {
    public static void main(String[] args) {
        BufferN buffer = new BufferN(100);

        new Producer(buffer,10).start();
        new Consumer(buffer).start();
        new Producer(buffer, 1000).start();
        new Consumer(buffer).start();
    }
}
