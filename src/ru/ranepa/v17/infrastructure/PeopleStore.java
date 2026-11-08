package ru.ranepa.v17.infrastructure;

import ru.ranepa.v17.application.StaffRepository;
import ru.ranepa.v17.domain.ShiftWorker;

import java.util.List;
import java.util.Optional;
import java.util.LinkedHashMap;
import java.util.Map;

public class PeopleStore implements StaffRepository {

    private final Map<String, ShiftWorker> staff = new LinkedHashMap<>();

    @Override
    public void save(ShiftWorker worker) {
        if (staff.containsKey(worker.name())) {
            throw new IllegalArgumentException("сотрудник " + worker.name() + "уже существует");
        }
        staff.put(worker.name(), worker);
    }

    @Override
    public Optional<ShiftWorker> findByName(String name) {
        return Optional.ofNullable(staff.get(name));
    }

    @Override
    public List<ShiftWorker> findAll() {
        return List.copyOf(staff.values());
    }
}
