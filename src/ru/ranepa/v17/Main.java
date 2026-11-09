package ru.ranepa.v17;

import ru.ranepa.v17.application.*;
import ru.ranepa.v17.domain.Course;
import ru.ranepa.v17.domain.Manager;
import ru.ranepa.v17.domain.Teacher;
import ru.ranepa.v17.infrastructure.CourseStore;
import ru.ranepa.v17.infrastructure.CsvExporter;
import ru.ranepa.v17.infrastructure.EmailService;
import ru.ranepa.v17.infrastructure.PeopleStore;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        CourseRepository courseRepo = new CourseStore();
        StaffRepository staffRepo = new PeopleStore();
        Notifier notifier = new EmailService();
        CourseExporter exporter = new CsvExporter();
        CourseService courseService = new CourseService((CourseStore) courseRepo, notifier);
        StaffService staffService = new StaffService(staffRepo);
        LaunchService launchService = new LaunchService(courseRepo);
        HandlingService handlingService = new HandlingService(courseRepo, staffRepo);
        StatisticsService statisticsService = new StatisticsService(courseRepo);
        ReportService reportService = new ReportService(courseRepo, staffRepo);
        ExportService exportService = new ExportService(courseRepo, exporter);
        NotificationService notificationService = new NotificationService(staffRepo, notifier);
        courseService.addCourse("Английский", 12000, "english");
        courseService.addCourse("Немецкий", 11000, "german");
        courseService.addCourse("Французский", 11500, "french");
        staffService.addWorker(new Teacher("Ксения", 40000));
        staffService.addWorker(new Manager("Юрий", 60000));

        reportService.printReport();
        statisticsService.printStatistics();

        courseService.cancelCourse("Английский");
        launchService.startAll();

        try {
            handlingService.handleByWorker("Юрий");
        } catch (IllegalArgumentException e) {
            System.out.println("Сбой роли: " + e.getMessage());
        }

        try{
        courseService.addCourse("Английский", 12050, "english");
        } catch (IllegalArgumentException e) {
            System.out.println("Курс не добавлен: " + e.getMessage());
        }
        System.out.println("Курсов в репозитории: " + courseRepo.findAll().size());
        System.out.println("Сотрудников в репозитории: " + staffRepo.findAll().size());

        System.out.println("Порядок обхода курсов:");
        for (Course course : courseRepo.findAll()) {
            System.out.println(course.getName() + " -> " + course.role());
        }

        exportService.exportAll();
        notificationService.notifyAll("Завтра родительское собрание");
    }
}
