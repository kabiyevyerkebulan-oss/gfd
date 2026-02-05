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

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("The score has been successfully updated!");
            } else {
                System.out.println("A candidate with that name was not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Question> getAllQuestions() {
        List<Question> list = new ArrayList<>();
        String sql = "SELECT * FROM questions"; // Убедись, что таблица есть в БД
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                // Предположим, у тебя такие поля в конструкторе Question
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
                // Создаем объект на основе данных из БД
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

            if (rowsAffected > 0) {
                System.out.println("The candidate '" + name + "' successfully deleted from the database");
            } else {
                System.out.println("A candidate with that name was not found");
            }
        } catch (Exception e) {
            System.out.println("Error when deleting: " + e.getMessage());
        }
    }
}