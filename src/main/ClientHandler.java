package main;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private final Socket clientSocket;
    private final MessageBroker broker;

    public ClientHandler(Socket socket, MessageBroker broker) {
        this.clientSocket = socket;
        this.broker = broker;
    }

    public void run() {
        try (
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
        ) {
            out.println("Welcome to Simple NATS Broker. Use SUB <subject> or PUB <subject> <message>");
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                String[] parts = inputLine.split(" ", 3);
                if (parts.length >= 2) {
                    String command = parts[0];
                    String subject = parts[1];

                    if (command.equalsIgnoreCase("SUB")) {
                        broker.subscribe(subject, out);
                    } else if (command.equalsIgnoreCase("PUB") && parts.length == 3) {
                        String message = parts[2];
                        broker.publish(subject, message);
                    } else {
                        out.println("Invalid command.");
                    }
                } else {
                    out.println("Invalid command.");
                }
            }

        } catch (IOException e) {
            System.out.println("Client disconnected.");
        }
    }
}
