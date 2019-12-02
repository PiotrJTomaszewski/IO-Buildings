package pl.put.poznan.buildings.logic;
import java.util.ArrayList;

/**
 * Represents a room.
 *
 */
public class Room extends Location {
	/**
	 * The area of the room in m^2.
	 */
    private int area;
    
    /**
     * The volume (cubage) of the room in m^3.
     */
    private int cube;
    
    /**
     * The heating energy level of the room.
     */
    private float heating;
    
    /**
     * The light power of the room.
     */
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
    
    /** 
     * Gives whole energy used by a certain room
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
     * Calculates the light of the room
     * @return The light of the room
     */
    public int getLight() {
    	return this.light;
    }

    /**
     * Calculates the mean of light in the room
     * @return The the light in the room divided by the volume of the room
     */
    public float getMeanLight() {
        return (float) this.getLight() / this.getArea();
    }
    
    /**
     * Calculates, whether energy used by room is greater than threshold.
     * 
     * @param thr - threshold, energy usage threshold
     * @return Location if room uses more energy than threshold or null otherwise
     */
    public ArrayList<Location> thresholding_energy(float thr) {
    	ArrayList<Location> isthresholded = new ArrayList<>();
    	if (this.getEnergyUse()>thr) {
    		isthresholded.add((Location)this);
    	}
    	return isthresholded;
    }
    
    public void setArea(int area) {
        this.area = area;
    }

    public void setCube(int cube) {
        this.cube = cube;
    }

    public void setHeating(float heating) {
        this.heating = heating;
    }

    public void setLight(int light) {
        this.light = light;
    }

    /**
     * Accepts a visitor and dispatches operation to it
     * @param visitor A visitor to accept
     */
    public void accept(LocationVisitor visitor) {
        visitor.visit(this);
    }
}
