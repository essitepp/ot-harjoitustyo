package sudoku.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;

public class SqlScoreDaoTest {
    
    ScoreDao scoreDao;
    File database;
    
    public SqlScoreDaoTest() {
    }
    
    @Before
    public void setUp() throws Exception {
        database = new File("test_database.db");
        String query = "CREATE TABLE IF NOT EXISTS Score (user STRING, time INTEGER);";
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:./" + database.getName(), "sa", "");
                Statement stmt = connection.createStatement()) {
            stmt.execute(query);
        }
        query = "INSERT INTO Score (user, time) VALUES ('testuser', 400);";
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:./" + database.getName(), "sa", "");
                Statement stmt = connection.createStatement()) {
            stmt.execute(query);
        }
        scoreDao = new SqlScoreDao(database.getName());   
    }
    
    @After
    public void tearDown() {
        database.delete();
    }

    @Test
    public void scoreIsReadCorrectly() {
        assertEquals("1. testuser: 6:40", scoreDao.list().get(0));
    }
    
    @Test
    public void savingScoreWorks() {
        scoreDao.add("anotherTest", 240);
        assertEquals("1. anotherTest: 4:00", scoreDao.list().get(0));
        assertEquals("2. testuser: 6:40", scoreDao.list().get(1));
    }

}
