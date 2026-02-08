package com.exam;

public abstract class Text {
    protected String text;
    protected double score;

    public Text() {
    }

    public Text(String text, double score) {
        this.text = text;
        this.score = score;
    }

    public abstract String getType();

    public String getText() {
        return text;
    }


    public void setText(String text) {
        this.text = text;
    }

    public double getScore() {
        return score;
    }


    public void setScore(double score) {
        this.score = score;
    }
}