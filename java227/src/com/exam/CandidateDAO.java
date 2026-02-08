package com.exam;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CandidateDAO {
    public void addCandidate(Candidate c) {
        String sql = "INSERT INTO candidates (name, score) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, c.getText());
            pstmt.setDouble(2, c.getScore());
            pstmt.executeUpdate();
            System.out.println("The candidate has been saved!");
        } catch (Exception e) { e.printStackTrace(); }
    }

    public void printAllCandidates() {
        String sql = "SELECT * FROM candidates";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("can_id") +
                        ", Name: " + rs.getString("name"));
            }
        } catch (Exception e) { e.printStackTrace(); }
    }

    public void createCandidate(Candidate c) {
        String sql = "INSERT INTO candidates (name, score) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, c.getText());
            pstmt.setDouble(2, c.getScore());
            pstmt.executeUpdate();
            System.out.println("The candidate " + c.getText() + " saved to the database");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateCandidateScore(String name, double newScore) {
        String sql = "UPDATE candidates SET score = ? WHERE name = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDouble(1, newScore);
            pstmt.setString(2, name);

            // ВЫПОЛНЯЕМ И СОХРАНЯЕМ РЕЗУЛЬТАТ
            int rowsAffected = pstmt.executeUpdate();

            // ВОТ СЮДА ПИШЕМ ЭТУ СТРОКУ
            System.out.println("Количество измененных строк: " + rowsAffected);

            if (rowsAffected > 0) {
                System.out.println("Кандидат " + name + " успешно обновлен.");
            } else {
                System.out.println("Кандидат с именем '" + name + "' не найден!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Question> getAllQuestions() {
        List<Question> list = new ArrayList<>();
        String sql = "SELECT * FROM questions";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Question(rs.getString("text"), null, 0, rs.getDouble("score")));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public List<Candidate> getAllCandidates() {
        List<Candidate> list = new ArrayList<>();
        String sql = "SELECT * FROM candidates";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Candidate c = new Candidate(rs.getString("name"), rs.getDouble("score"));
                list.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void deleteCandidate(String name) {
        String sql = "DELETE FROM candidates WHERE name = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);

            int rowsAffected = pstmt.executeUpdate();

            // ПИШЕМ СЮДА
            System.out.println("Удалено строк: " + rowsAffected);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void createExam(Exam e) {
        String sql = "INSERT INTO exams (exam_name, candidate_name, total_score) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "Final Exam"); // или e.getExamName(), если добавишь геттер
            pstmt.setString(2, e.getCandidate().getText());
            pstmt.setDouble(3, e.getTotalScore());
            pstmt.executeUpdate();
            System.out.println("Экзамен в БД сохранен!");
        } catch (Exception ex) { ex.printStackTrace(); }
    }

    public List<String> getAllExamsResults() {
        List<String> results = new ArrayList<>();
        String sql = "SELECT * FROM exams";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                results.add("Exam: " + rs.getString("exam_name") +
                        " | Candidate: " + rs.getString("candidate_name") +
                        " | Score: " + rs.getDouble("total_score"));
            }
        } catch (Exception ex) { ex.printStackTrace(); }
        return results;
    }
}