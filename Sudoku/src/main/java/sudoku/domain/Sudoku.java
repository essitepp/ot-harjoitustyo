package sudoku.domain;

import java.util.ArrayList;
import java.util.Scanner;
import javafx.scene.control.Button;
import sudoku.dao.*;

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
    
    public void newNumbers() {
        String[] rows = sudokuDao.getSudoku().split("\n");
        for (int i = 0; i < 9; i++) {
            String[] columns = rows[i].split("");
            for (int j = 0; j < 9; j++) {
                this.numbers[i][j] = Integer.valueOf(columns[j]);
            }
        }
    }

    public void changeNumber(Square square) {
        if (!square.isLocked()) {
            Button button = square.getButton();
            if (button.getText().equals(" ")) {
                button.setText("1");
            } else if (button.getText().equals("9")) {
                button.setText("1");
            } else {
                button.setText("" + (Integer.valueOf(button.getText()) + 1));
            }
        }
    }

    public void reset() {
        for (Square square : squares) {
            square.getButton().setText("" + numbers[square.getY()][square.getX()]);
            if (square.getButton().getText().equals("0")) {
                square.getButton().setText(" ");
                square.unlock();
            } else {
                square.lock();
            }
        }
        this.timer.reset();
    }
    
    public void saveScore(String user) {
        int time = timer.getMinutes() * 60 + timer.getSeconds();
//        String user = "";
//        while (true) {
//            user = scanner.nextLine();
//            if (user.length() > 0 && user.length() <= 20) {
//                break;
//            }
//        }
        scoreDao.add(user, time);
    }

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

    private boolean checkGrid(int row, int column) {
        ArrayList<Integer> list = new ArrayList<>();
        for (Square square : squares) {
            if (square.getY() >= row && square.getY() < row + 3 && square.getX() >= column && square.getX() < column + 3) {
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

}
