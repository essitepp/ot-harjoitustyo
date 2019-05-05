package sudoku.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SqlScoreDao implements ScoreDao {
    
    private String database;
    
    public SqlScoreDao(String database) {
        this.database = database;
    }

    @Override
    public void add(String user, int score) {
        String query = "INSERT INTO Score (user, time) VALUES ('" + user + "', " + score + ");";
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:./" + database, "sa", "");
                Statement stmt = connection.createStatement()) {
            stmt.execute(query);
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public ArrayList<String> list() {
        ArrayList<String> list = new ArrayList<>();
        String query = "SELECT user, time FROM Score ORDER BY time LIMIT 10;";
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:./" + database, "sa", "");
                PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            if (!rs.isBeforeFirst()) {
                list.add("Ei tuloksia");
            }
            int i = 1;
            while (rs.next()) {
                String s = "";
                s += i + ". ";
                s += rs.getString("user") + ": ";
                int time = rs.getInt("time");
                int minutes = time / 60;
                int seconds = time - 60 * minutes;
                if (seconds < 10) {
                    s += minutes + ":0" + seconds;
                } else {
                    s += minutes + ":" + seconds;
                }
                list.add(s);
                i++;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    


}
