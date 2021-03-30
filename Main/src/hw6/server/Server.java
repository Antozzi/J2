package hw6.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    private Thread threadIn;
    private Thread threadOut;


    public Server() {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server is ready...");
            System.out.println("Waiting for a connection...");
            Socket accept = serverSocket.accept();
            System.out.println("Connection established: " + accept);

            DataInputStream in = new DataInputStream(accept.getInputStream());
            DataOutputStream out = new DataOutputStream(accept.getOutputStream());

            Scanner scanner = new Scanner(System.in);

            threadOut = new Thread(() -> {
                while (true) {
                    try {
                        out.writeUTF(scanner.nextLine());
                    } catch (IOException e) {
                        System.out.println("Server is down...");
                        System.out.println("Connection is closed.");
                        close(serverSocket);
                        break;
                    }
                }
            });
            threadOut.start();
            threadIn = new Thread(() -> {
                while (true) {
                    try {
                        String message = in.readUTF();
                        System.out.println(message);
                    } catch (IOException e) {
                        close(serverSocket);
                        break;
                    }
                }
            });
            threadIn.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void close(ServerSocket socket) {
        threadIn.interrupt();
        threadOut.interrupt();
        try {
            System.out.println("Incoming client's channel is closed.");
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

