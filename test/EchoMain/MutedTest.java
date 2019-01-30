/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EchoMain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jack
 */
public class MutedTest {
    
    public MutedTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of turnOnOff method, of class Muted.
     */
    @Test
    public void testTurnOnOff() {
        Echo echo = new Echo();
        echo.setEchoState(echo.getMutedState());
        echo.turnOnOff();
        
        EchoState expected = echo.off;
        assertEquals("Echo has hasn't changed state when it should have", expected, echo.getEchoState());
    }

    /**
     * Test of mute method, of class Muted.
     */
    @Test
    public void testMute() {
        Echo echo = new Echo();
        echo.setEchoState(echo.getMutedState());
        echo.mute();
        
        EchoState expected = echo.listening;
        assertEquals("Echo has hasn't changed state when it should have", expected, echo.getEchoState());
    }

    /**
     * Test of askQuestion method, of class Muted.
     */
    @Test
    public void testAskQuestion() {
        Echo echo = new Echo();
        echo.setEchoState(echo.getMutedState());
        echo.askQuestion();
        
        EchoState expected = echo.muted;
        assertEquals("Echo has has changed state when it shouldn't have", expected, echo.getEchoState());
    }
    
}
