package com.amrita.jpl.cys21051.pract.chatclient_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class chatclient {

    public static void main(String[] args) {
        try {
            // Connect to the server
            Socket socket = new Socket("localhost", 2444);
            System.out.println("Connected to the server.");

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            // Send a message to the server
            output.println("Hi");
            System.out.println("Client: Hi");

            // Receive and print the server's response
            String serverResponse = input.readLine();
            System.out.println("Server: " + serverResponse);

            // Close the streams and socket
            input.close();
            output.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
