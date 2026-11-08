package ru.ranepa.v17.infrastructure;

import ru.ranepa.v17.application.CourseRepository;
import ru.ranepa.v17.domain.Course;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CourseStore implements CourseRepository {
    private final Map<String, Course> courses = new LinkedHashMap<>();

    @Override
    public void save(Course course) {
        if (courses.containsKey(course.getName())) {
            throw new IllegalArgumentException("курс с названием " + course.getName() + "уже существует");
        }
        courses.put(course.getName(), course);
    }

    @Override
    public Optional<Course> findByName(String name) {
        return Optional.ofNullable(courses.get(name));
    }

    @Override
    public List<Course> findAll() {
        return List.copyOf(courses.values());
    }
}
