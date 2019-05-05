
package sudoku.dao;

import java.util.ArrayList;


public interface ScoreDao {
    
    void add(String user, int score);
    ArrayList<String> list();
    
}
