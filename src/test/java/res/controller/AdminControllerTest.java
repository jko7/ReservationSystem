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
public class AdminControllerTest {
    
    public AdminControllerTest() {
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
     * Test of adminInfo method, of class AdminController.
     */
    @Test
    public void testAdminInfo() {
        System.out.println("adminInfo");
        Model model = null;
        AdminController instance = new AdminController();
        String expResult = "adminPage";
        String result = instance.adminInfo(model);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Maintenance method, of class AdminController.
     */
    @Test
    public void testMaintenance() {
        System.out.println("Maintenance");
        Model model = null;
        AdminController instance = new AdminController();
        String expResult = "redirect:/adminpage";
        String result = instance.Maintenance(model);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
