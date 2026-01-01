public class Candidate {
    private int can_id;
    private static int can_id_gen = 1;
    private String name;
    private double score;

    Candidate(String name, double score) {
        this.can_id = can_id_gen++;
        setName(name);
        setScore(score);
    }

    public int getCan_id() {
        return can_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Candidate:" +
                "ID: " + can_id +
                " Name: " + this.name +
                " Score: " + this.score;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Candidate other = (Candidate) obj;
        return name.equals(other.name);
    }
}