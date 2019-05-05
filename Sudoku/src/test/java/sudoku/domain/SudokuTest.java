package sudoku.domain;

import de.saxsys.javafx.test.JfxRunner;
import java.util.ArrayList;
import javafx.scene.control.Button;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import sudoku.dao.ScoreDao;
import sudoku.dao.SudokuDao;

@RunWith(JfxRunner.class)
public class SudokuTest {

    Sudoku sudoku;
    ArrayList<Square> squares;
    SudokuDao sudokuDao;
    ScoreDao scoreDao;
    Timer timer;
    int[][] numbers;

    public SudokuTest() {
    }

    @Before
    public void setUp() {
        squares = new ArrayList<>();
        sudokuDao = new FakeSudokuDao();
        scoreDao = new FakeScoreDao();
        sudoku = new Sudoku(squares, sudokuDao, scoreDao);
    }

    @Test
    public void changingNumberWorks() {
        Square square = new Square(0, 0, new Button("1"));
        sudoku.changeNumber(square);
        assertEquals("2", square.getButton().getText());
    }

    @Test
    public void changingNumberWorksWhenMax() {
        Square square = new Square(0, 0, new Button("9"));
        sudoku.changeNumber(square);
        assertEquals(" ", square.getButton().getText());
    }

    @Test
    public void changingNumberWorksWhenBlank() {
        Square square = new Square(0, 0, new Button(" "));
        sudoku.changeNumber(square);
        assertEquals("1", square.getButton().getText());
    }

    @Test
    public void changingNumberWhenLocked() {
        Square square = new Square(0, 0, new Button(" "));
        square.lock();
        sudoku.changeNumber(square);
        assertEquals(" ", square.getButton().getText());
    }

    @Test
    public void newNumbersCorrect() {
        int[][] expected = {
            {1, 2, 3, 4, 5, 6, 7, 8, 0},
            {1, 2, 3, 4, 5, 6, 7, 8, 0},
            {1, 2, 3, 4, 5, 6, 7, 8, 0},
            {1, 2, 3, 4, 5, 6, 7, 8, 0},
            {1, 2, 3, 4, 5, 6, 7, 8, 0},
            {1, 2, 3, 4, 5, 6, 7, 8, 0},
            {1, 2, 3, 4, 5, 6, 7, 8, 0},
            {1, 2, 3, 4, 5, 6, 7, 8, 0},
            {1, 2, 3, 4, 5, 6, 7, 8, 0},};

        sudoku.newNumbers();
        assertArrayEquals(expected, sudoku.getNumbers());
    }

    @Test
    public void resetSudokuWorks() {
        Square square = new Square(0, 0, new Button("5"));
        squares.add(square);
        sudoku.newNumbers();
        sudoku.reset();
        assertEquals("1", square.getButton().getText());
    }

    @Test
    public void resetSudokuWorksWhenBlank() {
        Square square = new Square(8, 8, new Button("5"));
        squares.add(square);
        sudoku.newNumbers();
        sudoku.reset();
        assertEquals(" ", square.getButton().getText());
    }

    @Test
    public void checkingSudokuWorksWhenCorrect() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                squares.add(new Square(i, j, new Button()));
            }
        }
        String numberString = "251348679\n463971852\n798562413\n614235987\n825197346\n937684125\n186759234\n549823761\n372416598";
        String[] rows = numberString.split("\n");
        for (int i = 0; i < 9; i++) {
            String[] columns = rows[i].split("");
            for (int j = 0; j < 9; j++) {
                sudoku.getNumbers()[i][j] = Integer.valueOf(columns[j]);
            }
        }
        sudoku.reset();
        assertEquals(true, sudoku.check());
    }
    
    @Test
    public void checkingSudokuWorksWhenNotDone() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                squares.add(new Square(i, j, new Button()));
            }
        }
        String numberString = "051348679\n463971852\n798562413\n614235987\n825197346\n937684125\n186759234\n549823761\n372416598";
        String[] rows = numberString.split("\n");
        for (int i = 0; i < 9; i++) {
            String[] columns = rows[i].split("");
            for (int j = 0; j < 9; j++) {
                sudoku.getNumbers()[i][j] = Integer.valueOf(columns[j]);
            }
        }
        sudoku.reset();
        assertEquals(false, sudoku.check());
    }

    @Test
    public void checkingSudokuWorksWhenRowIncorrect() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                squares.add(new Square(i, j, new Button()));
            }
        }
        String numberString = "451348679\n263971852\n798562413\n614235987\n825197346\n937684125\n186759234\n549823761\n372416598";
        String[] rows = numberString.split("\n");
        for (int i = 0; i < 9; i++) {
            String[] columns = rows[i].split("");
            for (int j = 0; j < 9; j++) {
                sudoku.getNumbers()[i][j] = Integer.valueOf(columns[j]);
            }
        }
        sudoku.reset();
        assertEquals(false, sudoku.check());
    }

    @Test
    public void checkingSudokuWorksWhenColumnIncorrect() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                squares.add(new Square(i, j, new Button()));
            }
        }
        String numberString = "521348679\n463971852\n798562413\n614235987\n825197346\n937684125\n186759234\n549823761\n372416598";
        String[] rows = numberString.split("\n");
        for (int i = 0; i < 9; i++) {
            String[] columns = rows[i].split("");
            for (int j = 0; j < 9; j++) {
                sudoku.getNumbers()[i][j] = Integer.valueOf(columns[j]);
            }
        }
        sudoku.reset();
        assertEquals(false, sudoku.check());
    }

    @Test
    public void checkingSudokuWorksWhenGridIncorrect() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                squares.add(new Square(i, j, new Button()));
            }
        }
        String numberString = "123456789\n234567891\n345678912\n456789123\n567891234\n678912345\n789123456\n891234567\n912345678";
        String[] rows = numberString.split("\n");
        for (int i = 0; i < 9; i++) {
            String[] columns = rows[i].split("");
            for (int j = 0; j < 9; j++) {
                sudoku.getNumbers()[i][j] = Integer.valueOf(columns[j]);
            }
        }
        sudoku.reset();
        assertEquals(false, sudoku.check());
    }
}
