package pl.put.poznan.buildings.logic;

public class Room extends Location {
    private int area;
    private int cube;
    private float heating;
    private int light;
    
    /**
     * Calculates the area of the room
     * @return The area of the room
     */
    public int getArea() {
    	return this.area;
    }
    
    /**
     * Calculates the volume of the room
     * @return The volume of the room
     */
    public int getCube() {
    	return this.cube;
    }
    
}
