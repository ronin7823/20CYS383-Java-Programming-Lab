package com.amrita.jpl.cys21051.pract.clientserver;


import java.io.*;
import java.net.*;

public class Server {
    private ServerSocket serverSocket;
    private String saveDirectory;

    public Server(int port, String saveDirectory) {
        this.saveDirectory = saveDirectory;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started. Listening for incoming file transfers...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(socket);
                clientHandler.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private class ClientHandler extends Thread {
        private Socket socket;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                DataInputStream dis = new DataInputStream(socket.getInputStream());

                String filename = dis.readUTF();
                int fileSize = dis.readInt();

                byte[] fileData = new byte[fileSize];
                dis.readFully(fileData);

                FileOutputStream fos = new FileOutputStream(saveDirectory + filename);
                fos.write(fileData);
                fos.close();

                System.out.println("File saved: " + saveDirectory + filename);

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        int port = 9999;
        String saveDirectory = "C:\\Users\\Iniyan Raja\\Desktop\\Semester 4\\Java Programming - LAB\\java_programming _lab_u4cys23\\src\\com\\amrita\\jpl";
        Server server = new Server(port, saveDirectory);
        server.start();
    }
}