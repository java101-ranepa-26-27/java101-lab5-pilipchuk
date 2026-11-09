package ru.ranepa.v17.application;

import ru.ranepa.v17.domain.Course;

import java.util.List;

public interface CourseExporter {
    void export(List<Course> courses);
}
