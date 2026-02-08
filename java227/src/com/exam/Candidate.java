package com.exam;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Objects;

public class Candidate extends Text {
    private int can_id;
    private static int can_id_gen = 1;

    public Candidate() {
        super();
        this.can_id = can_id_gen++;
    }

    public Candidate(String text, double score) {
        super(text, score);
        this.can_id = can_id_gen++;
    }

    public int getCan_id() {
        return can_id;
    }

    public void setCan_id(int can_id) {
        this.can_id = can_id;
    }

    public void setText(String text) { this.text = text; }
    public void setScore(double score) { this.score = score; }

    @Override
    @JsonIgnore // Эта строка скажет Спрингу: "Не пиши это поле в JSON"
    public String getType() {
        return "Candidate";
    }

    @Override
    public String toString() {
        return "com.exam.Candidate: ID: " + can_id + " Name: " + this.text + " Score: " + this.score;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Candidate other = (Candidate) obj;
        return Objects.equals(text, other.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }
}