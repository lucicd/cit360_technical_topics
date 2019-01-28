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
public enum BuildTime {
    RUSH3("3 days", 3),
    RUSH5("5 days", 5),
    RUSH7("7 days", 7),
    NORMAL("14 days", 14);
    
    private final String name;
    private final int duration;
    private static final int SIZE_THRESHOLD1 = 1000;
    private static final int SIZE_THRESHOLD2 = 2000;

    private BuildTime(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }
    
    public static List<String> getNames()
    {
        List<String> names = new ArrayList<>();
        for (BuildTime buildTime: BuildTime.values())
        {
            names.add(buildTime.getName());
        }
        return names;
    }
    
    public static BuildTime findByName(String name)
    {
        for (BuildTime buildTime: BuildTime.values())
        {
            if (buildTime.getName().equals(name)) {
                return buildTime;
            }
        }
        return null;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getDuration()
    {
        return duration;
    }
    
    public double getSurcharge(double surfaceArea)
    {
        double surcharge = 0;
        if (surfaceArea < SIZE_THRESHOLD1)
        {
            switch (getDuration())
            {
                case 3:
                    surcharge = 60;
                    break;
                case 5:
                    surcharge = 40;
                    break;
                case 7:
                    surcharge = 30;
                    break;
            }
        }
        else if (surfaceArea < SIZE_THRESHOLD2)
        {
            switch (getDuration())
            {
                case 3:
                    surcharge = 70;
                    break;
                case 5:
                    surcharge = 50;
                    break;
                case 7:
                    surcharge = 35;
                    break;
            }
        }
        else
        {
            switch (getDuration())
            {
                case 3:
                    surcharge = 80;
                    break;
                case 5:
                    surcharge = 60;
                    break;
                case 7:
                    surcharge = 40;
                    break;
            }
        }
        return surcharge;
    }
}
