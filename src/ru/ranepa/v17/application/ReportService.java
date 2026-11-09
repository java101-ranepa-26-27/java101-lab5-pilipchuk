package ru.ranepa.v17.application;

import ru.ranepa.v17.domain.Course;
import ru.ranepa.v17.domain.ShiftWorker;

public class ReportService {
    private final CourseRepository repository;
    private final StaffRepository staffRepository;

    public ReportService(CourseRepository repository, StaffRepository staffRepository) {
        this.repository = repository;
        this.staffRepository = staffRepository;
    }

    public void printReport() {
        for (Course item : repository.findAll()) {
            System.out.println(item.report());
        }
        for (ShiftWorker worker : staffRepository.findAll()) {
            System.out.println(worker.report());
        }
    }
}
