package ru.ranepa.v17;

import ru.ranepa.v17.domain.Course;
import ru.ranepa.v17.domain.EnglishCourse;
import ru.ranepa.v17.domain.GermanCourse;

public class ReportPrinter {

    public void print(Course item) {
        if (item instanceof EnglishCourse) {
            EnglishCourse first = (EnglishCourse) item;
            System.out.println("Английский: " + first.name + ", цена " + first.price);
        } else if (item instanceof GermanCourse) {
            GermanCourse second = (GermanCourse) item;
            System.out.println("Немецкий: " + second.name + ", цена " + second.price);
        } else {
            System.out.println("Неизвестный курс: " + item.name);
        }
    }
}
