import java.util.Objects;
import java.util.ArrayList;
import java.util.List;

public class Exam {
    private int exam_id;
    private static int exam_id_gen = 1;
    private Candidate candidate;
    private String examName;
    private double totalScore;
    private List<Question> questions;

    public Exam(String examName, Candidate candidate) {
        this.exam_id = exam_id_gen++;
        this.examName = examName;
        this.candidate = candidate;
        this.questions = new ArrayList<>();
        this.totalScore = 0.0;
    }
    public boolean isPassed(double candidateScore) {
        return candidateScore >= this.totalScore;
    }

    public int getExam_id() {
        return exam_id;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public double getTotalScore() {
        return totalScore;
    }

    @Override
    public String toString() {
        return "Экзамен #" + exam_id + " для " + candidate.getText() + ". Итог: " + totalScore;
    }

    public void addQuestion(Question q) {
        if (q != null) {
            this.questions.add(q);
            this.totalScore += q.getScore();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exam exam = (Exam) o;
        return Objects.equals(examName, exam.examName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(examName);
    }
}