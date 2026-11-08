package ru.ranepa.v17.domain;

public class GermanCourse extends Course {

    public GermanCourse(String name, double price) {
        super(name, price);
    }

    @Override
    public String role() {
        return "немецкий";
    }
}
