package sudoku.domain;

import de.saxsys.javafx.test.JfxRunner;
import javafx.scene.control.Button;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;

@RunWith(JfxRunner.class)
public class SquareTest {
    
    Square square;
    Button button;
    
    public SquareTest() {
    }
    
    @Before
    public void setUp() {
        button = new Button();
        square = new Square(5, 5, button);
    }

    @Test
    public void checkingLockStatusWorks() {
        assertEquals(false, square.isLocked());
    }
    
    @Test
    public void lockingSquareWorkd() {
        square.lock();
        assertEquals(true, square.isLocked());
    }
    
    @Test
    public void unlockingSquareWorkd() {
        square.lock();
        square.unlock();
        assertEquals(false, square.isLocked());
    }
    
    @Test
    public void getButtonWorks() {
        assertEquals(button, square.getButton());
    }
    
    @Test
    public void getXWorks() {
        assertEquals(5, square.getX());
    }
    
    @Test
    public void getYWorks() {
        assertEquals(5, square.getY());
    }
}
