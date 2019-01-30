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
public class ListeningTest {
    
    public ListeningTest() {
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
     * Test of turnOnOff method, of class Listening.
     */
    @Test
    public void testTurnOnOff() {
       
        Echo echo = new Echo();
        echo.setEchoState(echo.getListeningState());
        echo.turnOnOff();
        
        EchoState expected = echo.off;
        assertEquals("Echo has not changed state correctly", expected, echo.getEchoState());
    }

    /**
     * Test of mute method, of class Listening.
     */
    @Test
    public void testMute() {
       
        Echo echo = new Echo();
        echo.setEchoState(echo.getListeningState());
        echo.mute();
        
        EchoState expected = echo.muted;
        assertEquals("Echo has not changed state correctly", expected, echo.getEchoState());
    }

    /**
     * Test of askQuestion method, of class Listening.
     */
    @Test
    public void testAskQuestion() {
        
        Echo echo = new Echo();
        echo.setEchoState(echo.getListeningState());
        echo.askQuestion();
        
        EchoState expected = echo.answering;
        assertEquals("Echo has not changed state correctly", expected, echo.getEchoState());
    }
}
