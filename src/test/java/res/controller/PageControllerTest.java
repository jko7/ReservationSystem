/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package res.controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.ui.Model;

/**
 *
 * @author jk
 */
public class PageControllerTest {
    
    public PageControllerTest() {
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
     * Test of defaultPage method, of class PageController.
     */
    @Test
    public void testDefaultPage() {
        System.out.println("defaultPage");
        Model model = null;
        PageController instance = new PageController();
        String expResult = "";
        String result = instance.defaultPage(model);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nextPage method, of class PageController.
     */
    @Test
    public void testNextPage() {
        System.out.println("nextPage");
        PageController instance = new PageController();
        String expResult = "";
        String result = instance.nextPage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of previousPage method, of class PageController.
     */
    @Test
    public void testPreviousPage() {
        System.out.println("previousPage");
        PageController instance = new PageController();
        String expResult = "";
        String result = instance.previousPage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reset method, of class PageController.
     */
    @Test
    public void testReset() {
        System.out.println("reset");
        PageController instance = new PageController();
        String expResult = "";
        String result = instance.reset();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of giveOffset method, of class PageController.
     */
    @Test
    public void testGiveOffset() {
        System.out.println("giveOffset");
        PageController instance = new PageController();
        int expResult = 0;
        int result = instance.giveOffset();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of personalInfo method, of class PageController.
     */
    @Test
    public void testPersonalInfo() {
        System.out.println("personalInfo");
        Model model = null;
        PageController instance = new PageController();
        String expResult = "";
        String result = instance.personalInfo(model);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sendMail method, of class PageController.
     */
    @Test
    public void testSendMail() {
        System.out.println("sendMail");
        PageController instance = new PageController();
        String expResult = "";
        String result = instance.sendMail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
