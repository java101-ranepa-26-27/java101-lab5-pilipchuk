package ru.ranepa.v17.application;

public class ExportService {
    private final CourseRepository repository;
    private final CourseExporter exporter;

    public ExportService(CourseRepository repository, CourseExporter exporter) {
        this.repository = repository;
        this.exporter = exporter;
    }
    public void exportAll() {
        exporter.export(repository.findAll());
    }
}
