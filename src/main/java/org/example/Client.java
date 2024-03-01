package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class Client {

    public static void main(String[] args) {
        try (Socket clienSocket = new Socket("localhost", Server.PORT);
             PrintWriter writer = new PrintWriter(clienSocket.getOutputStream(), true);
             BufferedReader reader = new BufferedReader(new InputStreamReader(clienSocket.getInputStream()))) {
            writer.println("Sasha");
            System.out.println(reader.readLine());
            writer.println("Ivan");
            System.out.println(reader.readLine());
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
    }
}
