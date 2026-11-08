package ru.ranepa.v17.infrastructure;

public class EmailService {

    public void send(String recipient, String message) {
        System.out.println("EMAIL -> " + recipient + ": " + message);
    }
}
