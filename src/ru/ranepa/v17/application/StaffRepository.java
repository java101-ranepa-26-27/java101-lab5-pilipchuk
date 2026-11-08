package ru.ranepa.v17.application;

import ru.ranepa.v17.domain.ShiftWorker;

import java.util.List;
import java.util.Optional;

public interface StaffRepository {
    void save(ShiftWorker worker);
    Optional<ShiftWorker> findByName(String name);
    List<ShiftWorker> findAll();
}
