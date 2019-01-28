/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Drazen
 */
public class Quotes {
    private final static List<DeskQuote> quotes = new ArrayList<>();
    
    public static void add(Desk desk)
    {
        quotes.add(desk.getDeskQuote());
    }
    
    public static List<DeskQuote> getAll()
    {
        return quotes;
    }
}
