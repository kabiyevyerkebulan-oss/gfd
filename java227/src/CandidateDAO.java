import java.sql.*;

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
            pstmt.setString(1, c.getText()); // Используем метод getText() из твоего класса
            pstmt.setDouble(2, c.getScore());
            pstmt.executeUpdate();
            System.out.println("The candidate " + c.getText() + " saved to the database");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateCandidateScore(String name, double newScore) {
        String sql = "UPDATE candidates SET score = ? WHERE name = ?"; // Проверь имя таблицы!
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

    public void deleteCandidate(String name) {
        // SQL запрос с параметром (?) для безопасности
        String sql = "DELETE FROM candidates WHERE name = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Подставляем имя вместо знака вопроса
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