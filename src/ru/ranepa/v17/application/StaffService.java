package ru.ranepa.v17.application;

import ru.ranepa.v17.domain.ShiftWorker;

import java.util.Optional;

public class StaffService {
    private final StaffRepository repository;

    public StaffService(StaffRepository repository) {
        this.repository = repository;
    }
    public void addWorker(ShiftWorker worker) {
        repository.save(worker);
    }

    public Optional<ShiftWorker> findByName(String name) {
        return repository.findByName(name);
    }
}
