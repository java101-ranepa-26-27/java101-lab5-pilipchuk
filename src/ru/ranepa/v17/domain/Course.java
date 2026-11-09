package ru.ranepa.v17.domain;

public abstract class Course {

    public String name;
    public double price;
    public boolean available;

    public Course(String name, double price) {
        this.name = name;
        this.price = price;
        this.available = true;
    }

    public String getName() { return name; }


    public void start() {
        System.out.println(name + " запущен");

    }
    public void cancel() {
        if (!available) {
            throw new IllegalStateException("курс уже отменён: " + name);
        }
        available = false;
    }
    public String role() {
        return "курс";
    }
    public String report(){
        return name + "цена " + price;
    }

    public boolean isAvailable() {
        return available;
    }
    public double getPrice(){
        return price;
    }
}
