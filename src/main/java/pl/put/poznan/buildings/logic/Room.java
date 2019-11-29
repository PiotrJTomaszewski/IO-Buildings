package pl.put.poznan.buildings.logic;

public class Room extends Location {
    private int area;
    private int cube;
    private float heating;
    private int light;
    private float energy_const;
    
    /**
     * Gives energy used by certain room
     * 
     * @return energy used by a room
     * @author sebastian_michon
     */
    public float getEnergyUse() {
    	return this.heating*this.energy_const*this.cube;
    }
}
