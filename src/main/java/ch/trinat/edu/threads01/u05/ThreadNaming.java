package ch.trinat.edu.threads01.u05;

public class ThreadNaming {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyThread());
        Thread t2 = new Thread(new MyThread());
        t1.setName("Eins");
        t2.setName("Zwei");
        t1.start();
        t2.start();
        System.out.println(Thread.currentThread().getName());
        // alles in einer Zeile
        new Thread(new MyThread(), "Drei").start();
    }
}