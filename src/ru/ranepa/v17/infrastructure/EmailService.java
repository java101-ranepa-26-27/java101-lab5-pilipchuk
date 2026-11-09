package ru.ranepa.v17.infrastructure;

import ru.ranepa.v17.application.Notifier;

public class EmailService implements Notifier {
    @Override
    public void send(String recipient, String message) {
        System.out.println("EMAIL -> " + recipient + ": " + message);
    }
}
