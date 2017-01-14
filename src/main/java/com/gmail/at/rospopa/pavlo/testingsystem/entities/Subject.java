package com.gmail.at.rospopa.pavlo.testingsystem.entities;

public class Subject extends Entity{
    private String name;

    public Subject() {
    }

    public Subject(Long id) {
        super(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                '}';
    }
}
