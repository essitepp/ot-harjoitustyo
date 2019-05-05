
package sudoku.domain;

import javafx.scene.control.Button;

/**
 * Luokka kuvaa yhtä sudokun ruutua, ja sisältää tiedot ruudun painikkeesta, sijainnista ja lukintastatuksesta.
 */
public class Square {
    
    private Button button;
    private int y;
    private int x;
    private boolean locked;
    
    public Square(int y, int x, Button button) {
        this.button = button;
        this.y = y;
        this.x = x;
        this.locked = false;
    }
    
    /**
     * Metodi lukitsee ruudun.
     */
    public void lock() {
        this.locked = true;
    }
    
    /**
     * Metodi avaa ruudun lukituksen.
     */
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
}
