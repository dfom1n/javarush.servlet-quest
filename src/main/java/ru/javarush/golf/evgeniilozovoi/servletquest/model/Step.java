package ru.javarush.golf.evgeniilozovoi.servletquest.model;

public class Step {

    private Integer current;

    private Integer next;

    private String text;

    private String question;

    public Step(Integer current, String question) {
        this.current = current;
        this.next = -1;
        this.text = null;
        this.question = question;
    }

    public Step(Integer current, Integer next, String text, String question) {
        this.current = current;
        this.next = next;
        this.text = text;
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public int getCurrent() {
        return current;
    }

    public int getNext() {
        return next;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Step{" +
                "current=" + current +
                ", next=" + next +
                ", text='" + text + '\'' +
                ", question='" + question + '\'' +
                '}';
    }
}
