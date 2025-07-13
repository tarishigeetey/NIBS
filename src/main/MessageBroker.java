package main;

import java.io.PrintWriter;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class MessageBroker {
    private final ConcurrentHashMap<String, CopyOnWriteArrayList<PrintWriter>> subscribers = new ConcurrentHashMap<>();

    public void subscribe(String subject, PrintWriter out) {
        subscribers.putIfAbsent(subject, new CopyOnWriteArrayList<>());
        subscribers.get(subject).add(out);
        out.println("Subscribed to " + subject);
    }

    public void publish(String subject, String message) {
        if (subscribers.containsKey(subject)) {
            for (PrintWriter out : subscribers.get(subject)) {
                out.println("[" + subject + "] " + message);
            }
        }
    }
}
