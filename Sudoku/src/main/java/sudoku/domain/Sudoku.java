package sudoku.domain;

import java.util.ArrayList;
import javafx.scene.control.Button;
import sudoku.dao.*;

/**
 * Luokka vastaa sovelluslogiikasta
 */
public class Sudoku {

    private ArrayList<Square> squares;
    private int[][] numbers;
    private SudokuDao sudokuDao;
    private ScoreDao scoreDao;
    private Timer timer;

    public Sudoku(ArrayList<Square> squares, SudokuDao sudokuDao, ScoreDao scoreDao) {
        this.squares = squares;
        this.sudokuDao = sudokuDao;
        this.scoreDao = scoreDao;
        this.numbers = new int[9][9];
        this.timer = new Timer();
    }

    public Timer getTimer() {
        return this.timer;
    }

    public int[][] getNumbers() {
        return this.numbers;
    }
    
    /**
     * Metodi asettaa sudokun numbers-taulukkoon tietokannasta haetun satunnaisen sudokun numerot.
     */
    public void newNumbers() {
        String[] rows = sudokuDao.getSudoku().split("\n");
        if (rows.length > 0) {
            for (int i = 0; i < 9; i++) {
                String[] columns = rows[i].split("");
                for (int j = 0; j < 9; j++) {
                    this.numbers[i][j] = Integer.valueOf(columns[j]);
                }
            }
        }
    }
    
    /**
     * Metodi kasvattaa parametrina annetun Square-olion numeroa yhdellä.
     * @param square Square
     */
    public void changeNumber(Square square) {
        if (!square.isLocked()) {
            Button button = square.getButton();
            if (button.getText().equals(" ")) {
                button.setText("1");
            } else if (button.getText().equals("9")) {
                button.setText(" ");
            } else {
                button.setText("" + (Integer.valueOf(button.getText()) + 1));
            }
        }
    }
    
    /**
     * Metodi asettaa sudokuruudukon painikkeiden numerot numbers-taulukon mukaisiksi. 
     */
    public void reset() {
        for (Square square : squares) {
            square.getButton().setText("" + numbers[square.getY()][square.getX()]);
            if (square.getButton().getText().equals("0")) {
                square.getButton().setText(" ");
                square.getButton().setStyle("-fx-text-fill: #4970b7");
                square.unlock();
            } else {
                square.lock();
                square.getButton().setStyle("-fx-text-fill: black");
            }
        }
        this.timer.reset();
    }
    
    /**
     * Metodi tallentaa tuloksen parametrina annetulla nimimerkillä.
     * @param user nimimerkki
     */
    public void saveScore(String user) {
        int time = timer.getMinutes() * 60 + timer.getSeconds();
        scoreDao.add(user, time);
    }

    /**
     * Metodi tarkastaa sudokun ratkaisun.
     * @return true jos ratkaisu on oikein, muulloin false
     */
    public boolean check() {
        for (int i = 0; i < 9; i++) {
            if (!checkRow(i)) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (!checkColumn(i)) {
                return false;
            }
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!checkGrid(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkRow(int row) {
        ArrayList<Integer> list = new ArrayList<>();
        for (Square square : squares) {
            if (square.getY() == row) {
                if (square.getButton().getText().equals(" ")) {
                    return false;
                }
                int number = Integer.valueOf(square.getButton().getText());
                if (list.contains(number)) {
                    return false;
                } else {
                    list.add(number);
                }
            }
        }
        return true;
    }

    private boolean checkColumn(int column) {
        ArrayList<Integer> list = new ArrayList<>();
        for (Square square : squares) {
            if (square.getX() == column) {
                int number = Integer.valueOf(square.getButton().getText());
                if (list.contains(number)) {
                    return false;
                } else {
                    list.add(number);
                }
            }
        }
        return true;
    }

    private boolean checkGrid(int row, int column) {
        ArrayList<Integer> list = new ArrayList<>();
        for (Square square : squares) {
            if (square.getY() >= row && square.getY() < row + 3 && square.getX() >= column && square.getX() < column + 3) {
                int number = Integer.valueOf(square.getButton().getText());
                if (list.contains(number)) {
                    return false;
                } else {
                    list.add(number);
                }
            }
        }
        return true;
    }

}
