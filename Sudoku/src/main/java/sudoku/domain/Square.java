
package sudoku.domain;

import javafx.scene.control.Button;


public class Square {
    
    private Button button;
    private int y;
    private int x;
    private boolean locked;
    
    public Square(int y, int x, Button button) {
        this.button = button;
        this.y = y;
        this.x = x;
    }
    
    public void lock() {
        this.locked = true;
    }
    
    public void unlock() {
        this.locked = false;
    }
    
    public Button getButton() {
        return this.button;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
    
    public boolean isLocked() {
        return this.locked;
    }
    
    public String toString() {
        return this.y + "," + this.x;
    }
    
}
