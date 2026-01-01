import java.util.Objects;

public class Candidate extends Text {
    private int can_id;
    private static int can_id_gen = 1;

    public Candidate(String text, double score) {
        super(text, score);
        this.can_id = can_id_gen++;
    }

    @Override
    public String getType() {
        return "Candidate";
    }

    @Override
    public String toString() {
        return "Candidate:" +
                "ID: " + can_id +
                " Name: " + this.text +
                " Score: " + this.score;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Candidate other = (Candidate) obj;
        return text.equals(other.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }
}