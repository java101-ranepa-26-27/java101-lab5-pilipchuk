package ru.ranepa.v17.application;

import ru.ranepa.v17.domain.Course;

public class LaunchService {
    private final CourseRepository repository;

    public LaunchService(CourseRepository repository) {
        this.repository = repository;
    }
    public void startAll() {
        for (Course item : repository.findAll()) {
            if (item.isAvailable()) {
                item.start();
            }
        }
    }
}
