import java.util.Arrays;

public class Question {
    private int question_id;
    private int question_id_gen = 1;
    private String text;
    private String[] options;
    private int correct_a_i;
    private double sv;

    Question(){question_id = question_id_gen++;}

    Question(String text, String[] options, int correct_a_i, double sv){
        this();
        setText(text);
        setOptions(options);
        setCorrect_a_i(correct_a_i);
        setSv(sv);
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

}
