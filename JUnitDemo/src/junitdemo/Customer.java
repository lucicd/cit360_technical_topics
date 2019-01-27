/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junitdemo;

/**
 *
 * @author Drazen
 */
public class Customer {
    
    private String name;

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    
    public Customer(String name)
    {
        this.name = name;
    }
    
    public Customer getClone()
    {
        Customer customer = new Customer(this.name);
        return customer;
    }
    
    public Customer getMe()
    {
        return this;
    }
}
