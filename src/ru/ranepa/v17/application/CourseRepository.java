package ru.ranepa.v17.application;

import ru.ranepa.v17.domain.Course;

import java.util.List;
import java.util.Optional;

public interface CourseRepository {
    void save(Course course);
    Optional<Course> findByName(String name);
    List<Course> findAll();
}
