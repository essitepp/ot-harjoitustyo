
package sudoku.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SqlScoreDao implements ScoreDao {

    @Override
    public void add(String user, int score) {
        String query = "INSERT INTO Score (user, time) VALUES ('" + user + "', " + score + ");";
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:./database", "sa", "");
                Statement stmt = connection.createStatement()) {
            stmt.execute(query);
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public int list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
