package com.amrita.jpl.cys21051.pract.chatclient_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class chatserver {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(2444);
            System.out.println("Server started. Waiting for client...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);

            String clientMessage;

            while (true) {
                clientMessage = input.readLine();
                System.out.println("Client: " + clientMessage);

                if (clientMessage.equalsIgnoreCase("exit")) {
                    break;
                }

                if (clientMessage.equalsIgnoreCase("Hi")) {
                    String serverResponse = "Hello";
                    output.println(serverResponse);
                    System.out.println("Server: " + serverResponse);
                }
            }

            serverSocket.close();
            clientSocket.close();
            input.close();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
