/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package experiments;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Drazen
 */
public class ClientTest {
    
    public ClientTest() {
    }

    /**
     * Test of getName method, of class Client.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Client instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Client.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Client instance = null;
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumberaccount method, of class Client.
     */
    @Test
    public void testGetNumberaccount() {
        System.out.println("getNumberaccount");
        Client instance = null;
        String expResult = "";
        String result = instance.getNumberaccount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumberaccount method, of class Client.
     */
    @Test
    public void testSetNumberaccount() {
        System.out.println("setNumberaccount");
        String numberaccount = "";
        Client instance = null;
        instance.setNumberaccount(numberaccount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBalance method, of class Client.
     */
    @Test
    public void testGetBalance() {
        System.out.println("getBalance");
        Client instance = null;
        Double expResult = null;
        Double result = instance.getBalance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBalance method, of class Client.
     */
    @Test
    public void testSetBalance() {
        System.out.println("setBalance");
        Double balance = null;
        Client instance = null;
        instance.setBalance(balance);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
