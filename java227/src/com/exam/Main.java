package com.exam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        CandidateDAO cdao = new CandidateDAO();

        ArrayList<Question> questions = new ArrayList<>();
        String[] options = {"A1", "A2", "A3", "A4"};

        questions.add(new Question("Q1", options, 0, 5.0));
        questions.add(new Question("Q2", options, 1, 3.0));

        System.out.println("List of questions (Sorted):");
        questions.sort(Comparator.comparing(Question::getText));
        for (Question q : questions) {
            System.out.println(q);
        }

        Candidate[] candidates = new Candidate[2];
        for (int i = 0; i < 2; i++) {
            System.out.print("\nEnter the candidate's name " + (i + 1) + ": ");
            String name = sc.nextLine();
            System.out.print("Enter the candidate's score " + (i + 1) + ": ");
            double score = sc.nextDouble();
            sc.nextLine();

            candidates[i] = new Candidate(name, score);

            cdao.createCandidate(candidates[i]);
        }

        System.out.println("\n--- Comparison ---");
        if (candidates[0].getScore() > candidates[1].getScore()) {
            System.out.println(candidates[0].getText() + " scored more points!");
        } else if (candidates[0].getScore() < candidates[1].getScore()) {
            System.out.println(candidates[1].getText() + " scored more points!");
        } else {
            System.out.println("Both scored the same points!");
        }

        System.out.print("\nEnter the passing score: ");
        double ps = sc.nextDouble();
        sc.nextLine();

        Exam javaTest = new Exam("Midterm", candidates[0]);
        javaTest.addQuestion(questions.get(0));
        javaTest.addQuestion(questions.get(1));

        System.out.println("\n--- com.exam.Exam Info ---");
        System.out.println(javaTest);

        // Проверка результата
        if (javaTest.isPassed(candidates[0].getScore())) {
            System.out.println("Result: " + candidates[0].getText() + " passed!");
        } else {
            System.out.println("Result: " + candidates[0].getText() + " failed");
        }

        System.out.println("\n--- Database Operations ---");

        System.out.print("Enter the candidate's name to update the score: ");
        String nameToUpdate = sc.next();
        System.out.print("Enter a new score: ");
        double updatedScore = sc.nextDouble();
        cdao.updateCandidateScore(nameToUpdate, updatedScore);

        System.out.print("\nEnter the name of the second candidate to update: ");
        nameToUpdate = sc.next();
        System.out.print("Enter a new score: ");
        updatedScore = sc.nextDouble();
        cdao.updateCandidateScore(nameToUpdate, updatedScore);

        System.out.print("\nEnter the name of the candidate to delete: ");
        String nameToDelete = sc.next();
        cdao.deleteCandidate(nameToDelete);

        System.out.println("\nThe program is completed");
    }
}