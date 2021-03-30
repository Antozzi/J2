package hw6.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * Typical TCP\IP socket
 * 127.0.0.1:8080
 */

public class Client {

    private Thread threadIn;
    private Thread threadOut;

    public Client() {

        try {
            Socket socket = new Socket("127.0.0.1", 8080);
            Scanner scanner = new Scanner(System.in);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            threadOut = new Thread(() -> {
                while (true) {
                    try {
                        out.writeUTF(scanner.nextLine());
                    } catch (IOException e) {
                        System.out.println("Client is down...");
                        System.out.println("Connection is closed.");
                        close(socket);
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
                        System.out.println("Incoming server's channel is closed.");
                        close(socket);
                        break;
                    }
                }
            });
            threadIn.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void close(Socket socket) {
        threadIn.interrupt();
        threadOut.interrupt();
        try {
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
