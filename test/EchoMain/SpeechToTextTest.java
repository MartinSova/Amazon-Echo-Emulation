/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EchoMain;

import static EchoMain.EchoMain.TOKEN;
import static EchoMain.EchoMain.renewAccessToken;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jackmarsh
 */
public class SpeechToTextTest {
    
    public SpeechToTextTest() {
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
     * Test of recognizeSpeech method, of class SpeechToText.
     */
    @Test
    public void testWavToString() {
        System.out.println("SpeechToText");
        final String KEY1 = "6cfd3579bfee48fc97efde7e9e03d742";

        TOKEN = renewAccessToken(KEY1);
        final byte[] speech = SpeechToText.readData("src/EchoMain/soundAssets/test.wav");
        final String toParser = SpeechToText.recognizeSpeech(TOKEN, speech);
        JSONParser j = new JSONParser();
        final String result = j.parseCognitive(toParser);
        final String expResult = "Frankly my dear I don't give a damn.";
        assertEquals(expResult, result);
        
    }   
}
