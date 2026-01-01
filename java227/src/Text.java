public abstract class Text {
    protected String text;
    protected double score;

    public Text(String text, double score) {
        this.text = text;
        this.score = score;
    }

    public abstract String getType();

    public String getText() {
        return text;
    }

    public double getScore() {
        return score;
    }
}
