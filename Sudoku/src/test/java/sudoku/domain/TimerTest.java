/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author essitepp
 */
public class TimerTest {
    
    Timer timer;
    
    public TimerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        timer = new Timer();
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
//     @Test
//     public void hello() {}
    
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
