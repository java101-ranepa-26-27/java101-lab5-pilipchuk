package ru.ranepa.v17.infrastructure;

import ru.ranepa.v17.application.CourseExporter;
import ru.ranepa.v17.domain.Course;

import java.util.List;

public class CsvExporter implements CourseExporter {
    public void export(String line) {
        System.out.println("CSV: " + line);
    }
    @Override
    public void export(List<Course> courses) {
        for (Course course : courses) {
            export(course.role() + ";" + course.getName() + ";" + course.getPrice());
        }
    }
}
