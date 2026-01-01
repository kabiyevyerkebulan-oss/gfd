import java.util.Objects;

public class Exam extends Text {
    private int exam_id;
    private static int exam_id_gen = 1;

    public Exam (String text, double score){
        super(text, score);
        this.exam_id = exam_id_gen++;
    }

    @Override
    public String getType() {
        return "Exam";
    }

    public boolean isPassed(double candidateScore) {
        return candidateScore >= this.score;
    }

    @Override
    public String toString() {
        return "Exam: " + text + " (Passing grade: " + score + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Exam other = (Exam) obj;
        return text.equals(other.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }
}
