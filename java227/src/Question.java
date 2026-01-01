import java.util.Arrays;
import java.util.Objects;

 public class Question extends Text {
    private int question_id;
    private static int question_id_gen = 1;
    private String[] options;
    private int correct_a_i;

    public Question(String text, String[] options, int correct_a_i, double score){
        super(text, score);
        this.question_id = question_id_gen++;
        this.options = options;
        this.correct_a_i = correct_a_i;
    }

     @Override
     public String getType() {
         return "Question";
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
                ", correct_a_i=" + correct_a_i +
                ", score=" + score;
    }

     @Override
     public boolean equals(Object obj) {
         if (this == obj) return true;
         if (obj == null || getClass() != obj.getClass()) return false;
         Question question = (Question) obj;
         return text.equals(question.text);
     }

     @Override
     public int hashCode() {
         return Objects.hash(text);
     }

}
