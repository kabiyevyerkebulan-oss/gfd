public class Candidate {
    private int can_id;
    private int can_id_gen = 1;
    private String name;
    private double score;

    Candidate(){can_id = can_id_gen++;}

    Candidate(String name, double score) {
        this();
        setName(name); // 'this' указывает на поле класса
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
                "Candidate ID=" + can_id +
                " Name=" + name +
                " Score=" + score;
    }
}
