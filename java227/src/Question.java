import java.util.Arrays;
import java.util.Objects;

 public class Question {
    private int question_id;
    private static int question_id_gen = 1;
    private String text;
    private String[] options;
    private int correct_a_i;
    private double sv;

    Question(String text, String[] options, int correct_a_i, double sv){
        this.question_id = question_id_gen++;
        this.text = text;
        this.options = options;
        this.correct_a_i = correct_a_i;
        this.sv = sv;
    }
    public int getQuestion_id(){
        return question_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getCorrect_a_i() {
        return correct_a_i;
    }

    public void setCorrect_a_i(int correct_a_i) {
        this.correct_a_i = correct_a_i;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public double getSv() {
        return sv;
    }

    public void setSv(double sv) {
        this.sv = sv;
    }

    public boolean checkAnswer(int candidate_a_i) {
        return candidate_a_i == this.correct_a_i;
    }

    @Override
    public String toString() {
        return "Question:" +
                "question_id=" + question_id +
                ", text='" + text + '\'' +
                ", options=" + Arrays.toString(options) +
                ", currect_a_i=" + correct_a_i +
                ", sv=" + sv;
    }

     @Override
     public boolean equals(Object obj) {
         if (this == obj) return true;
         if (obj == null || getClass() != obj.getClass()) return false;
         Question question = (Question) obj;
         return question_id == question.question_id;
     }

     @Override
     public int hashCode() {
         return Objects.hash(question_id);
     }

}
