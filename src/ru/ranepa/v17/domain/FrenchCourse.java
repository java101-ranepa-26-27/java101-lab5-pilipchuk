package ru.ranepa.v17.domain;

public class FrenchCourse extends Course {

    public FrenchCourse(String name, double price) {
        super(name, price);
    }

    @Override
    public String role() {
        return "французский";
    }
}
