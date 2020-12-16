package ch.trinat.edu.socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TippDesTagesServer {

    public static void main(String[] args) {
        System.out.println("Server Start");
        TippDesTagesServer server = new TippDesTagesServer();
        while (true) {
            server.los();
        }

    }

    public void los() {
        try (ServerSocket serverSock = new ServerSocket(4242)) {
            while(true) {
                Socket sock = serverSock.accept();
                PrintWriter writer = new PrintWriter(sock.getOutputStream());
                String tipp = getTipp();
                writer.println(tipp);
                writer.close();
                System.out.println(tipp);
            }
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    private String getTipp() {
        return "Mein Tipp";
    }

}