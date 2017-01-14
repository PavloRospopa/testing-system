package com.gmail.at.rospopa.pavlo.testingsystem.entities;

public class Question extends Entity {
    private String desc;
    private Test test;

    public Question() {
    }

    public Question(Long id) {
        super(id);
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question id=" + super.getId() +
                ", test='" + test.getName() + '\'' +
                '}';
    }
}
