
package sudoku.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;


public class SqlSudokuDao implements SudokuDao {
    
    @Override
    public String getSudoku() {
        String sudoku = "";
        int id = getRandomId();
        String query = "SELECT numbers FROM Sudoku WHERE id = " + id + ";";
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:./database", "sa", "");
                PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                sudoku = rs.getString("numbers");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return sudoku;
    }
    
    private int getRandomId() {
        int amount = 0;
        String query = "SELECT COUNT(id) FROM Sudoku";
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:./database", "sa", "");
                PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                amount = rs.getInt("COUNT(id)");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        Random random = new Random();
        int id = random.nextInt(amount) + 1;
        return id;
    }
    
}
