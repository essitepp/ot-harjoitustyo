
package sudoku.domain;

import sudoku.dao.SudokuDao;

public class FakeSudokuDao implements SudokuDao{

    @Override
    public String getSudoku() {
        return "123456780\n123456780\n123456780\n123456780\n123456780\n123456780\n123456780\n123456780\n123456780";
    }
    
}
