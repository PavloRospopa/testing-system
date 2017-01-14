package com.gmail.at.rospopa.pavlo.testingsystem.entities;

public class Test extends Entity{
    private String name;
    private Subject subject;

    public Test() {
    }

    public Test(Long id) {
        super(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Test{" +
                "name='" + name + '\'' +
                ", subject='" + subject.getName()+ '\'' +
                '}';
    }
}
