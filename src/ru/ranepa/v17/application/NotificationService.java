package ru.ranepa.v17.application;

import ru.ranepa.v17.domain.ShiftWorker;

public class NotificationService {
    private final StaffRepository repository;
    private final Notifier notifier;

    public NotificationService(StaffRepository repository, Notifier notifier) {
        this.repository = repository;
        this.notifier = notifier;
    }
    public void notifyAll(String message) {
        for (ShiftWorker worker : repository.findAll()) {
            notifier.send(worker.name(), message);
        }
    }
}
