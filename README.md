# NIBS

A lightweight, beginner-friendly NATS-style message broker written in pure Java. This project demonstrates core concepts of TCP socket programming, concurrency, and publish/subscribe messaging protocols — without using frameworks like Spring Boot.

---

## 🚀 Features

- ✅ TCP socket-based server
- ✅ PUB/SUB message protocol
- ✅ Multi-client support using threads
- ✅ Thread-safe in-memory topic management
- ✅ Ultra-lightweight and fast
- ✅ Perfect for learning network protocols and system design

---

## 📁 Project Structure

SimpleNatsBroker/
├── MainServer.java // Entry point, runs the broker
├── ClientHandler.java // Handles per-client commands
├── MessageBroker.java // Core pub/sub logic
└── README.md


---

## 📦 Requirements

- Java 17+
- Terminal (with `telnet` or `nc`)
- macOS/Linux/Windows

---

## 🛠 How to Run

### 1. Clone or Copy the Repo

```bash
git clone https://github.com/yourusername/NIBS.git
cd SimpleNatsBroker
```
### 2. Compile & Run the Server
```bash
javac *.java
java MainServer
```
You should see:
```ngnix
Broker started on port 4222
```

## 🧠 Protocol Overview

Command	Format	Description
SUB	SUB <subject>	Subscribe to a topic
PUB	PUB <subject> <message>	Publish message to a topic
All messages are broadcast to all active subscribers of the specified subject.

🛡 Concurrency & Safety

Uses ConcurrentHashMap and CopyOnWriteArrayList for thread-safe state management.
Each client is handled in its own thread.

## 🔍 Future Improvements

 Unsubscribe command (UNSUB)
 Message persistence with file or database
 Logging support
 WebSocket support for browser clients
 Test suite with JUnit

## 🧑‍💻 Author

Tarishi Geetey
Built as a learning project to understand protocol design, sockets, and messaging systems. Inspired by the NATS protocol.

## 🙌 Contributions Welcome!

Feel free to fork and enhance the broker — PRs with persistence, retries, or message filtering are appreciated!

```yaml

Would you like this pushed to a GitHub repo with the `.java` files so you can share or deploy easily? I can also add **unit tests** if you want to move toward TDD.

```

