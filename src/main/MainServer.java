package main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {
    public static void main(String[] args) {
        int port = 4222; // default NATS port
        MessageBroker broker = new MessageBroker();

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Broker started on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");
                new Thread(new ClientHandler(clientSocket, broker)).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
