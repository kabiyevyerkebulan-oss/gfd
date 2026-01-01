import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Question> questions = new ArrayList<>();

        String[] options1 = {"A1", "A2", "A3", "A4"};
        String[] options2 = {"A1", "A2", "A3", "A4"};

        questions.add(new Question("Q1", options1, 0, 5.0));
        questions.add(new Question("Q2", options2, 1, 3.0));

        Question q1 = questions.get(0);
        Question q2 = questions.get(1);

        System.out.println("List of questions:");
        for(int i = 0; i < questions.size(); i++) {
            System.out.println(questions.get(i));
        }

        questions.sort(Comparator.comparing(Question::getText));

        System.out.println("\nTesting Methods:");
        System.out.println("Is the answer to Q1 with index 0 correct? " + q1.checkAnswer(0));
        System.out.println("Is the answer to Q2 with index 1 correct? " + q2.checkAnswer(2));

        System.out.println("\nObject Comparison");
        System.out.println("Is Q1 equal to Q1 (by ID)? " + q1.equals(q1));
        System.out.println("Is Q1 equal to Q2 (by ID)? " + q1.equals(q2));

        Candidate[] candidates = new Candidate[2];
        for (int i = 0; i < 2; i++) {
            System.out.print("\nEnter the candidate's name " + (i + 1) + ": ");
            String name = sc.nextLine();
            System.out.print("Enter the candidate's score " + (i + 1) + ": ");
            double score = sc.nextDouble();
            sc.nextLine(); // поглощаем перенос строки
            candidates[i] = new Candidate(name, score);
        }

        System.out.println("\nCandidates:");
        for (Candidate c : candidates) {
            System.out.println(c);
        }

        if (candidates[0].getScore() > candidates[1].getScore()) {
            System.out.println(candidates[0].getText() + " Scored more points!");
        } else if (candidates[0].getScore() < candidates[1].getScore()) {
            System.out.println(candidates[1].getText() + " Scored more points!");
        } else {
            System.out.println("Both candidates scored the same number of points!");
        }

        System.out.println("It's the same person? " + candidates[0].equals(candidates[1]));

        System.out.print("Enter the passing score: ");
        Double ps = sc.nextDouble();

        Exam javaTest = new Exam(
                "E1", ps
        );

        System.out.println(javaTest);

        if (javaTest.isPassed(candidates[0].getScore())) {
            System.out.println("Result: " + candidates[0].getText() + " passed the exam successfully!");
        } else {
            System.out.println("Result: " + candidates[0].getText() + " We need to practice more");
        }

        if (javaTest.isPassed(candidates[1].getScore())) {
            System.out.println("Result: " + candidates[1].getText() + " passed the exam successfully!");
        } else {
            System.out.println("Result: " + candidates[1].getText() + " We need to practice more");
        }

        Exam anotherTest = new Exam("Java Basics", 70.0);
        System.out.println("The exams are identical? " + javaTest.equals(anotherTest));
}}
