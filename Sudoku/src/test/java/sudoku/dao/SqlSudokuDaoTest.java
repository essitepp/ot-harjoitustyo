package sudoku.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SqlSudokuDaoTest {
    
    SudokuDao sudokuDao;
    File database;
    
    public SqlSudokuDaoTest() {
    }
    
    @Before
    public void setUp() throws SQLException {
        database = new File("test_database.db");
        String query = "CREATE TABLE IF NOT EXISTS Sudoku (id INTEGER PRIMARY KEY, numbers STRING);";
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:./" + database.getName(), "sa", "");
                Statement stmt = connection.createStatement()) {
            stmt.execute(query);
        }
        query = "INSERT INTO Sudoku (numbers) VALUES ('003020600\n900305001\n001806400\n008102900\n700000008\n006708200\n002609500\n800203009\n005010300');";
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:./" + database.getName(), "sa", "");
                Statement stmt = connection.createStatement()) {
            stmt.execute(query);
        }
        sudokuDao = new SqlSudokuDao(database.getName());
    }
    
    @After
    public void tearDown() {
        database.delete();
    }
    
    @Test
    public void gettingSudokuWorks() {
        String expected = "003020600\n900305001\n001806400\n008102900\n700000008\n006708200\n002609500\n800203009\n005010300";
        assertEquals(expected, sudokuDao.getSudoku());
    }


}
