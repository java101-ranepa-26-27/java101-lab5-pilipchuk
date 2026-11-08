package ru.ranepa.v17.domain;

public class EnglishCourse extends Course {

    public EnglishCourse(String name, double price) {
        super(name, price);
    }

    @Override
    public String role() {
        return "английский";
    }
}
