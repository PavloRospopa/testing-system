package com.gmail.at.rospopa.pavlo.testingsystem.entities;

public class Answer extends Entity{
    private String answerText;
    private boolean isRight;
    private Question question;

    public Answer() {
    }

    public Answer(Long id) {
        super(id);
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public boolean isRight() {
        return isRight;
    }

    public void setRight(boolean isRight) {
        this.isRight = isRight;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answer text='" + answerText + '\'' +
                ", isRight=" + isRight +
                ", question id=" + question.getId() +
                '}';
    }
}
