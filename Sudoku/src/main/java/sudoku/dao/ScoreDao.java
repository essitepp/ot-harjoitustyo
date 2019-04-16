
package sudoku.dao;


public interface ScoreDao {
    
    void add(String user, int score);
    int list();
    
}
