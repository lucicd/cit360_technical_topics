/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junitdemo;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Drazen
 */
public class JUnitDemoTest {

    //assertArrayEquals
    @Test
    public void testQ1Months()
    {
        System.out.println("q1Months");
        assertArrayEquals(JUnitDemo.q1Months(), new String[] {"Jan", "Feb", "Mar"});
    }
    
    //assertEquals
    @Test
    public void testFact()
    {
        System.out.println("fact");
        assertEquals(JUnitDemo.fact(3), 6);
        assertEquals(JUnitDemo.fact(4), 24);
        assertEquals(JUnitDemo.fact(5), 120);
    }
    
    //assertFalse
    @Test
    public void testGreaterThan()
    {
        System.out.println("greaterThan");
        assertFalse(JUnitDemo.greaterThan(3, 4));
        assertFalse(JUnitDemo.greaterThan(3, 3));
        assertTrue(JUnitDemo.greaterThan(4, 3));
    }
    
    //assertNotNull
    //assertNull
    @Test
    public void testGetDay()
    {
        System.out.println("getDay ");
        assertNotNull(JUnitDemo.getDay(1));
        assertNull(JUnitDemo.getDay(15));
    }
    
    //assertNotSame
    @Test
    public void testCloneCustomer()
    {
        System.out.println("Customer.clone");
        Customer red1 = new Customer("Jane");
        Customer red2 = red1.getClone();
        assertEquals(red1.getName(), red2.getName());
        assertNotSame(red1, red2);
    }
    
    //assertSame
    @Test
    public void testGetMe()
    {
        System.out.println("Customer.getMe");
        Customer red1 = new Customer("Jane");
        Customer red2 = red1.getMe();
        assertEquals(red1.getName(), red2.getName());
        assertSame(red1, red2);
    }
    
    //assertThat
    @Test
    public void manyTests()
    {
        System.out.println("Many Tests");
        assertThat(JUnitDemo.alwaysTrue(), is(true));
        assertThat(JUnitDemo.alwaysTrue(), not(false));
        
        Customer red1 = new Customer("Peter");
        Customer red2 = red1.getClone();
        assertThat(red2, not(is(red1)));
        assertThat(red2, not(sameInstance(red1)));
        
        red2 = red1.getMe();
        assertThat(red2, is(red1));
        assertThat(red2, sameInstance(red1));
        
        assertThat(red1, instanceOf(Customer.class));
    }

    //assertTrue
    @Test
    public void testAlwaysTrue() 
    {
        System.out.println("alwaysTrue");
        assertTrue(JUnitDemo.alwaysTrue());
    }
}
