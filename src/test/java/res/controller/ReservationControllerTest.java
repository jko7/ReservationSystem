/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package res.controller;

import java.util.List;
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
public class ReservationControllerTest {
    
    public ReservationControllerTest() {
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
     * Test of showReservation method, of class ReservationController.
     */
    @Test
    public void testShowReservation() {
        System.out.println("showReservation");
        Model model = null;
        ReservationController instance = new ReservationController();
        String expResult = "";
        String result = instance.showReservation(model);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addReservation method, of class ReservationController.
     */
    @Test
    public void testAddReservation() {
        System.out.println("addReservation");
        String[] times = null;
        ReservationController instance = new ReservationController();
        String expResult = "";
        String result = instance.addReservation(times);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of confirmReservations method, of class ReservationController.
     */
    @Test
    public void testConfirmReservations() {
        System.out.println("confirmReservations");
        ReservationController instance = new ReservationController();
        String expResult = "";
        String result = instance.confirmReservations();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cancelReservations method, of class ReservationController.
     */
    @Test
    public void testCancelReservations() {
        System.out.println("cancelReservations");
        ReservationController instance = new ReservationController();
        String expResult = "";
        String result = instance.cancelReservations();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of giveAllReservations method, of class ReservationController.
     */
    @Test
    public void testGiveAllReservations() {
        System.out.println("giveAllReservations");
        ReservationController instance = new ReservationController();
        List<String> expResult = null;
        List<String> result = instance.giveAllReservations();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
