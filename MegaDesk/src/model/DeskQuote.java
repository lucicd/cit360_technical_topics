/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Drazen
 */
public class DeskQuote {
    private final double BASE_PRICE = 200;
    private final double AREA_SURCHARGE_PER_UNIT = 1;
    private final double AREA_SURCHARGE_THRESHOLD = 1000;
    private final double SURCHARGE_PER_DRAWER = 50;
    
    private final String customer;
    private final Date orderDate;
    private final Desk desk;

    public DeskQuote(String customer, Desk desk) {
        this.customer = customer;
        this.desk = desk;
        this.orderDate = new Date();
    }
    
    public double getBasePrice()
    {
        return BASE_PRICE;
    }
    
    public double getAreaSurcharge()
    {
        double area = desk.getArea();
        double surcharge = 0;
        if (area > AREA_SURCHARGE_THRESHOLD) {
            surcharge = (area - AREA_SURCHARGE_THRESHOLD) *
                    AREA_SURCHARGE_PER_UNIT;
        }
        return surcharge;
    }
    
    public double getMaterialSurcharge()
    {
        return desk.getSurfaceType().getSurcharge();
    }
    
    public double getDrawersSurcharge()
    {
        return desk.getNumberOfDrawers() * SURCHARGE_PER_DRAWER;
    }
    
    public double getRushOrderSurcharge()
    {
        return desk.getBuildTime().getSurcharge(desk.getArea());
    }
    
    public double getPrice()
    {
        return getMaterialSurcharge() + getRushOrderSurcharge() +
                getBasePrice() + getAreaSurcharge() +
                getDrawersSurcharge();
    }

    public String getCustomer() {
        return customer;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public Desk getDesk() {
        return desk;
    }
}
