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
public class AnsweringTest {
    
    public AnsweringTest() {
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
     * Test of turnOnOff method, of class Answering.
     */
    @Test
    public void testTurnOnOff() {
        Echo echo = new Echo();
        echo.setEchoState(echo.getAnsweringState());
        echo.turnOnOff();
        
        EchoState expected = echo.answering;
        assertEquals("Echo has changed state when it shouldn't have", expected, echo.getEchoState());
    }

    /**
     * Test of mute method, of class Answering.
     */
    @Test
    public void testMute() {
        Echo echo = new Echo();
        echo.setEchoState(echo.getAnsweringState());
        echo.mute();
        
        EchoState expected = echo.answering;
        assertEquals("Echo has changed state when it shouldn't have", expected, echo.getEchoState());
    }

    /**
     * Test of askQuestion method, of class Answering.
     */
    @Test
    public void testAskQuestion() {
        Echo echo = new Echo();
        echo.setEchoState(echo.getAnsweringState());
        echo.askQuestion();
        
        EchoState expected = echo.listening;
        assertEquals("Echo has hasn't changed state when it should have", expected, echo.getEchoState());
    }
    
}
