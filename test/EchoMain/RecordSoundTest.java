/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EchoMain;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jackmarsh
 */
public class RecordSoundTest {

    public RecordSoundTest() {
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
     * Test of getInter method, of class RecordSound.
     */
    @Test
    public void testGetInter1() {
        System.out.println("getInter false");
        RecordSound instance = new RecordSound();
        boolean expResult = false;
        instance.setInter(false);
        boolean result = instance.getInter();
        assertEquals(expResult, result);
    }

    /**
     * Test of getInter method, of class RecordSound.
     */
    @Test
    public void testGetInter2() {
        System.out.println("getInter true");
        RecordSound instance = new RecordSound();
        boolean expResult = true;
        instance.setInter(true);
        boolean result = instance.getInter();
        assertEquals(expResult, result);
    }

    /**
     * Test of setInter method, of class RecordSound.
     */
    @Test
    public void testSetInter1() {
        System.out.println("setInter true");
        boolean inter = false;
        RecordSound instance = new RecordSound();
        instance.setInter(inter);
        assertEquals(instance.inter, false);
    }

    /**
     * Test of setInter method, of class RecordSound.
     */
    @Test
    public void testSetInter2() {
        System.out.println("setInter true");
        boolean inter = true;
        RecordSound instance = new RecordSound();
        instance.setInter(inter);
        assertEquals(instance.inter, true);
    }

    /**
     * Test of setupStream method, of class RecordSound.
     */
    @Test
    public void testSetupStream() {
        System.out.println("setupStream");
        int expResult = -1;
        AudioInputStream result = RecordSound.setupStream();
        assertEquals(expResult, result.getFrameLength());
    }

    /**
     * Test of calculateRMSLevel method, of class RecordSound.
     */
    @Test
    public void testCalculateRMSLevel() {
        System.out.println("calculateRMSLevel");
        byte[] buffer1 = "0".getBytes();
        byte[] buffer2 = "ABCDABCD".getBytes();
        int expResult1 = 0;
        int expResult2 = 1;
        
        int result1 = RecordSound.calculateRMSLevel(buffer1);
        assertEquals(expResult1, result1);
        int result2 = RecordSound.calculateRMSLevel(buffer2);
        assertEquals(expResult2, result2);
    }

}
