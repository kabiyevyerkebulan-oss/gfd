public class Exam {
    private int exam_id;
    private static int exam_id_gen = 1;
    private String title;
    private double passing_score;

    Exam (String title, double passing_score){
        this.exam_id = exam_id_gen++;
        setTitle(title);
        setPassing_score(passing_score);
    }

    public int getExam_id() {
        return exam_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPassing_score() {
        return passing_score;
    }

    public void setPassing_score(double passing_score) {
        this.passing_score = passing_score;
    }

    public boolean isPassed(double candidateScore) {
        return candidateScore >= this.passing_score;
    }

    @Override
    public String toString() {
        return "Экзамен: " + title + " (Проходной балл: " + passing_score + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Exam other = (Exam) obj;
        return title.equals(other.title); // Считаем экзамены одинаковыми, если названия совпали
    }



}
