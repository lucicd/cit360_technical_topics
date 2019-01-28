/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Drazen
 */
public class Desk {
    private double width;
    private double depth;
    private int numberOfDrawers;
    private SurfaceType surfaceType;
    private BuildTime buildTime;
    private DeskQuote deskQuote;

    public Desk(double width, double depth, int numberOfDrawers, 
            String customer, BuildTime buildTime, SurfaceType surfaceType) {
        this.width = width;
        this.depth = depth;
        this.numberOfDrawers = numberOfDrawers;
        this.buildTime = buildTime;
        this.surfaceType = surfaceType;
        this.deskQuote = new DeskQuote(customer, this);
    }
    
    public double getArea()
    {
        return width * depth;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public int getNumberOfDrawers() {
        return numberOfDrawers;
    }

    public void setNumberOfDrawers(int numberOfDrawers) {
        this.numberOfDrawers = numberOfDrawers;
    }

    public SurfaceType getSurfaceType() {
        return surfaceType;
    }

    public void setSurfaceType(SurfaceType surfaceType) {
        this.surfaceType = surfaceType;
    }

    public DeskQuote getDeskQuote() {
        return deskQuote;
    }

    public void setDeskQuote(DeskQuote deskQuote) {
        this.deskQuote = deskQuote;
    }

    public BuildTime getBuildTime() {
        return buildTime;
    }

    public void setBuildTime(BuildTime buildTime) {
        this.buildTime = buildTime;
    }
}
