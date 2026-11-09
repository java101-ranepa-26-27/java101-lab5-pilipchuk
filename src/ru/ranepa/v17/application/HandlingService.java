package ru.ranepa.v17.application;

import ru.ranepa.v17.domain.Course;
import ru.ranepa.v17.domain.CourseHandler;
import ru.ranepa.v17.domain.ShiftWorker;

import java.util.List;

public class HandlingService {
    private final CourseRepository courseRepository;
    private final StaffRepository staffRepository;

    public HandlingService(CourseRepository courseRepository, StaffRepository staffRepository) {
        this.courseRepository = courseRepository;
        this.staffRepository = staffRepository;
    }
    public void handleByWorker(String workerName) {
        ShiftWorker worker = null;
        for (ShiftWorker candidate : staffRepository.findAll()) {
            if (candidate.name().equals(workerName)) {
                worker = candidate;
                break;
            }
        }
        if (worker == null) {
            throw new IllegalArgumentException("сотрудник не найден: " + workerName);
        }
        if (!(worker instanceof CourseHandler handler)) {
            throw new IllegalArgumentException(workerName + " не умеет обрабатывать курсы");
        }
        List<Course> courses = courseRepository.findAll();
        if (courses.isEmpty()) {
            throw new IllegalStateException("нет курсов для обработки");
        }
        handler.handle(courses.get(0));
    }
}
