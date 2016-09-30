package res.controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import res.domain.Account;


public class RegistrationControllerTest {
    
    public RegistrationControllerTest() {
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
     * Test of view method, of class RegistrationController.
     */
    @Test
    public void testView() {
        System.out.println("view");
        RegistrationController instance = new RegistrationController();
        String expResult = "";
        String result = instance.view();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of register method, of class RegistrationController.
     */
    @Test
    public void testRegister() {
        System.out.println("register");
        Account account = null;
        BindingResult bindingResult = null;
        RegistrationController instance = new RegistrationController();
        String expResult = "";
        String result = instance.register(account, bindingResult);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showPersonalInfo method, of class RegistrationController.
     */
    @Test
    public void testShowPersonalInfo() {
        System.out.println("showPersonalInfo");
        Model model = null;
        String username = "";
        RegistrationController instance = new RegistrationController();
        String expResult = "";
        String result = instance.showPersonalInfo(model, username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
