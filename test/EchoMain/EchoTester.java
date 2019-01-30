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
public class EchoTester {
    
    public EchoTester() {
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
     * Test of setEchoState method, of class Echo.
     */
    @Test
    public void testSetEchoState() {
        Echo echo = new Echo();
        echo.setEchoState(echo.listening);
       
        
        EchoState expected = echo.listening;
        assertEquals("setEchoState has not changed the echo's state", expected, echo.getEchoState());
    }

    /**
     * Test of getEchoState method, of class Echo.
     */
    @Test
    public void testGetEchoState() {
        Echo echo = new Echo();
    
        EchoState expected = echo.off;
        assertEquals("getEchoState has not returned the current state correctly", expected, echo.getEchoState());
    }

    /**
     * Test of turnOnOff method, of class Echo.
     */
    @Test
    public void testTurnOnOff() {
        Echo echo = new Echo();
        echo.turnOnOff();
        EchoState expected = echo.listening;
        
        assertEquals("turnOnOFF has not changed the current state correctly", expected, echo.getEchoState());
        
    }

    /**
     * Test of mute method, of class Echo.
     */
    @Test
    public void testMute() {
        Echo echo = new Echo();
        echo.setEchoState(echo.getListeningState());
        echo.mute();
        EchoState expected = echo.muted;
        
        assertEquals("mute has not changed the current state correctly", expected, echo.getEchoState());
    }

    /**
     * Test of askQuestion method, of class Echo.
     */
    @Test
    public void testAskQuestion() {
        Echo echo = new Echo();
        echo.setEchoState(echo.getListeningState());
        echo.askQuestion();
        EchoState expected = echo.answering;
        
        assertEquals("askQuestion has not changed the current state correctly", expected, echo.getEchoState());
    }

    /**
     * Test of getOffState method, of class Echo.
     */
    @Test
    public void testGetOffState() {
        System.out.println("getOffState");
        Echo instance = new Echo();
        EchoState expResult = instance.off;
        EchoState result = instance.getOffState();
        assertEquals("Off state has not been returtned",expResult, result);
       
    }

    /**
     * Test of getListeningState method, of class Echo.
     */
    @Test
    public void testGetListeningState() {
        System.out.println("getListeningState");
        Echo instance = new Echo();
        EchoState expResult = instance.listening;
        EchoState result = instance.getListeningState();
        assertEquals("Listening state has not been returtned",expResult, result);
    
    }

    /**
     * Test of getAnsweringState method, of class Echo.
     */
    @Test
    public void testGetAnsweringState() {
        System.out.println("getAnsweringState");
        Echo instance = new Echo();
        EchoState expResult = instance.answering;
        EchoState result = instance.getAnsweringState();
        assertEquals("Answering state has not been returtned",expResult, result);
    }

    /**
     * Test of getMutedState method, of class Echo.
     */
    @Test
    public void testGetMutedState() {
        System.out.println("getMutedState");
        Echo instance = new Echo();
        EchoState expResult = instance.muted;
        EchoState result = instance.getMutedState();
        assertEquals("Muted state has not been returtned",expResult, result);
    }
    
}
