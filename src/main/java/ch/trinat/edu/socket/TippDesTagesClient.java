package ch.trinat.edu.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

class TippDesTagesClient {

    public static void main(String[] args) {
        System.out.println("Client Start");
        new TippDesTagesClient().los();
    }

    public void los() {
        try (Socket s = new Socket("localhost", 4242)) {
            InputStreamReader streamReader = new InputStreamReader(s.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);
            String advice = reader.readLine();
            System.out.println("Ratschlag fuer heute: " + advice);
            reader.close();
        } catch(IOException ex) {
            ex.printStackTrace();
        }

    }
}