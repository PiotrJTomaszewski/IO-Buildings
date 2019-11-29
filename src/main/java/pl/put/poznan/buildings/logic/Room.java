package pl.put.poznan.buildings.logic;

public class Room extends Location {
    private int area;
    private int cube;
    private float heating;
    private int light;
    
    /**
     * Gives energy used by certain room
     * 
     * @return energy used by a room
     * @author sebastian_michon
     */
    public float getEnergyUse() {
    	return this.heating/this.cube;
    }
    
    /**
     * Calculates the area of the room
     * @return The area of the room
     */
    public int getArea() {
    	return this.area;
    }
    
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
    
}
