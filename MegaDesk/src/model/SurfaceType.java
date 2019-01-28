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
public enum SurfaceType {
    OAK("Oak", 200),
    LAMINATE("Laminate", 100),
    PINE("Pine", 50),
    ROSEWOOD("Rosewood", 300),
    VENEER("Veneer", 125);
    
    private final String name;
    private final double surcharge;

    private SurfaceType(String name, double surcharge) {
        this.name = name;
        this.surcharge = surcharge;
    }
    
    public static List<String> getNames()
    {
        List<String> names = new ArrayList<>();
        for (SurfaceType surfaceType: SurfaceType.values())
        {
            names.add(surfaceType.getName());
        }
        return names;
    }
    
    public static SurfaceType findByName(String name)
    {
        for (SurfaceType surfaceType: SurfaceType.values())
        {
            if (surfaceType.getName().equals(name)) {
                return surfaceType;
            }
        }
        return null;
    }
    
    public String getName()
    {
        return name;
    }
    
    public double getSurcharge()
    {
        return surcharge;
    }
}
