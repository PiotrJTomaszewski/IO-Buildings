package pl.put.poznan.buildings.logic;

import java.util.ArrayList;

public abstract class Location {
    private long id;
    private String name;

    public Location() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public abstract float getHeatingEnergyUse();
    public abstract float getHeating();
    public abstract int getArea();
    public abstract int getLight();
    public abstract ArrayList<Location> thresholding_energy(float thr);
    public abstract int getCube();

    @Override
    public String toString() {
        return String.format("Building id:%d name:%s", id, name);
    }
}
