
package sudoku.domain;

import java.util.ArrayList;
import sudoku.dao.ScoreDao;

public class FakeScoreDao implements ScoreDao {

    @Override
    public void add(String user, int score) {   
    }

    @Override
    public ArrayList<String> list() {
        ArrayList<String> list = new ArrayList<>();
        return list;
    }
    
}
