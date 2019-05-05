package sudoku.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TimerTest {
    
    Timer timer;
    
    public TimerTest() {
    }
       
    @Before
    public void setUp() {
        timer = new Timer();
    }
    
    @Test
    public void startMinutesCorrect() {
        assertEquals(0, timer.getMinutes());
    }
    
    @Test
    public void startSecondsCorrect() {
        assertEquals(0, timer.getSeconds());
    }
    
    @Test
    public void increasingSeconds() {
        timer.increase();
        assertEquals(1, timer.getSeconds());
    }
    
    @Test
    public void increasingMinutes() {
        for (int i = 0; i < 60; i++) {
            timer.increase();
        }
        assertEquals(1, timer.getMinutes());
    }
    
    @Test
    public void resetTimer() {
        for (int i = 0; i < 100; i++) {
            timer.increase();
        }
        timer.reset();
        assertEquals(0, timer.getSeconds());
    }
    
    @Test
    public void testToString() {
        assertEquals("00:00", timer.toString());
    }
    
    @Test
    public void testToString2() {
        for (int i = 0; i < 610; i++) {
            timer.increase();
        }
        assertEquals("10:10", timer.toString());
    }
}
