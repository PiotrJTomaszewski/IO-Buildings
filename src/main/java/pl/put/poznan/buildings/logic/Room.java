package pl.put.poznan.buildings.logic;
import java.util.ArrayList;

import com.sun.tools.javac.util.List;

public class Room extends Location {
    private int area;
    private int cube;
    private float heating;
    private int light;
    
    /**
     * Gives heating energy used by a certain room
     * 
     * @return heating energy used by a room
     * @author sebastian_michon
     */
    public float getHeatingEnergyUse() {
    	return this.heating/this.cube;
    }
    
    /** Gives whole energy used by a certain room
     * 
     * @return whole energy used by a room
     * @author sebastian_michon
     */
    public float getEnergyUse() {
    	return this.getHeatingEnergyUse();
    }
    
    
    /**
     * Calculates the area of the room
     * @return The area of the room
     */
    public int getArea() {
    	return this.area;
    }
    
    /**
     * Calculates heating of the room
     * @return Heating value of the room
     */
    public float getHeating() {
    	return this.heating;
    }
    
    /**
     * Calculates the volume of the room
     * @return The volume of the room
     */
    public int getCube() {
    	return this.cube;
    }
    
    /**
     * calculates, whether energy used by room is greater than threshold
     * 
     * @param thr - threshold, if building uses more energy than threshold
     * @return Location if room uses more energy than threshold or null otherwise
     */
    public ArrayList<Location> thresholding_energy(float thr) {
    	ArrayList<Location> isthresholded = new ArrayList<>();
    	if (this.getEnergyUse()>thr) {
    		isthresholded.add((Location)this);
    	}
    	return isthresholded;
    }
    
}
