package com.exam;

public class Question extends Text {
    private int question_id;
    private static int question_id_gen = 1;
    private String[] options;
    private int correct_a_i;

    // Пустой конструктор
    public Question() {
        super();
        this.question_id = question_id_gen++;
    }

    public Question(String text, String[] options, int correct_a_i, double score){
        super(text, score);
        this.question_id = question_id_gen++;
        this.options = options;
        this.correct_a_i = correct_a_i;
    }

    // Геттеры и сеттеры для всех полей
    public int getQuestion_id() { return question_id; }
    public void setQuestion_id(int question_id) { this.question_id = question_id; }

    public String[] getOptions() { return options; }
    public void setOptions(String[] options) { this.options = options; }

    public int getCorrect_a_i() { return correct_a_i; }
    public void setCorrect_a_i(int correct_a_i) { this.correct_a_i = correct_a_i; }

    @Override
    public String getType() { return "com.exam.Question"; }
}
