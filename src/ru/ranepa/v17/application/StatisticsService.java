package ru.ranepa.v17.application;

import ru.ranepa.v17.domain.Course;

import java.util.List;

public class StatisticsService {
    private final CourseRepository repository;

    public StatisticsService(CourseRepository repository) {
        this.repository = repository;
    }
    public double averagePrice() {
        double sum = 0;
        List<Course> courses = repository.findAll();
        for (Course item : courses) {
            sum += item.getPrice();
        }
        return courses.isEmpty() ? 0.0 : sum / courses.size();
    }

    public void printStatistics() {
        List<Course> courses = repository.findAll();
        int count = courses.size();
        int known = 0;
        for (Course item : courses) {
            if (item.isAvailable()) {
                known++;
            }
        }
        System.out.println("Позиций: " + count + ", известных типов: " + known
                + ", средняя цена: " + averagePrice());
    }
}
