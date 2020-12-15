package ch.trinat.edu.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class JavaWebServer {

    private static final int fNumberOfThreads = 100;
    private static final Executor fThreadPool = Executors.newFixedThreadPool(fNumberOfThreads);


    public static void main(String[] args) throws IOException {
        System.setProperty("java.net.preferIPv4Stack", "true");
        try (ServerSocket socket = new ServerSocket(8080)) {
            System.out.println("open browser and enter url: http://localhost:8080");
            while (true) {
                System.out.println("wait for accept");
                final Socket connection = socket.accept();

                Runnable task = new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Task: " + Thread.currentThread().getName());
                        handleRequest(connection);
                        try {
                            connection.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                };
                fThreadPool.execute(task);
            }
        }
    }

    public static String getCurrentTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;
    }

    protected static void handleRequest(Socket s) {
        try (PrintWriter out = new PrintWriter(s.getOutputStream(), true)) {
            String webServerAddress = s.getInetAddress().toString();
            System.out.println("New Connection:" + webServerAddress);
            printHeader(s);
            out.println("HTTP/1.0 200");
            out.println("Content-type: text/html");
            out.println("Server-name: myJavaServer");
            String response = "<html>\n "
                    + "<head>\n" + "<title>My Java Web Server</title></head>\n"
                    + "<h1>Welcome to my Java Web Server!</h1>\n"
                    + "<p>Server Time: " + getCurrentTimeStamp()
                    + "</p>\n" + "</html>\n";
            out.println("Content-length: " + response.length());
            out.println("");
            out.println(response);
            out.flush();
            s.close();
        } catch (IOException e) {
            System.out.println("Failed respond to client request: " + e.getMessage());
        }

    }

    private static void printHeader(Socket s) {
        int c;
        StringBuffer raw = new StringBuffer();
        try {
            do {
                c = s.getInputStream().read();
                raw.append((char) c);
            } while (s.getInputStream().available() > 0);
            System.out.println(raw.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
