package ru.ranepa.v17.application;

import ru.ranepa.v17.domain.Course;
import ru.ranepa.v17.domain.EnglishCourse;
import ru.ranepa.v17.domain.FrenchCourse;
import ru.ranepa.v17.domain.GermanCourse;
import ru.ranepa.v17.infrastructure.CourseStore;

import java.util.Optional;

public class CourseService {
    private final CourseRepository repository;
    private final Notifier notifier;

    public CourseService(CourseStore store, Notifier notifier) {
        this.repository = store;
        this.notifier = notifier;
    }
    public Course addCourse(String name, double price, String type) {
        Course course;
        if (type.equals("english")) {
            course = new EnglishCourse(name, price);
        } else if (type.equals("german")) {
            course = new GermanCourse(name, price);
        } else {
            course = new FrenchCourse(name, price);
        }
        repository.save(course);
        notifier.send(name, "курс добавлен");
        return course;
    }

    public Optional<Course> findByName(String name) {
        return repository.findByName(name);
    }

    public void cancelCourse(String name) {
        Course course = repository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("курс не найден: " + name));
        course.cancel();
    }
}
