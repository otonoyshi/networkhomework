package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientSocet {
    public static void main(String[] args) {

        String host = "localhost";
        int port = 8080;


        try (Socket socket = new Socket(host, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            out.println("GET / HTTP/1.1\n" + "Host: localhost\n");
            System.out.println(in.readLine());

        } catch (IOException e) {
            throw new RuntimeException(e);

        }


    }
}
