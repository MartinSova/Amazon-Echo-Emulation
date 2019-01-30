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
 * @author jackmarsh
 */
public class ComputationalTest {
    
    public ComputationalTest() {
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
     * Test of compute method, of class Computational.
     */
    @Test
    public void testCompute() {
        System.out.println("compute");
        String json = "What is 2 + 2?";
        Computational instance = new Computational();
        String expResult = "4";
        String toParser = instance.compute(json);
        JSONParser j = new JSONParser();
        String result = j.parseWolfram(toParser);
        assertEquals(expResult, result);
    }
    
}
