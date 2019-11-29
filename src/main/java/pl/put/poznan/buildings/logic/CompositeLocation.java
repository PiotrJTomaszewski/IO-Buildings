package pl.put.poznan.buildings.logic;

import java.util.List;

public abstract class CompositeLocation extends Location {
    private List<Location> locations;
    private float EnergyUse;
    
    /**
	 * Gives energy used by given composite location
	 * 
	 * @return energy used by composite location
	 * @author sebastian_michon
	 */
    public float getEnergyUse() {
	    float summa=0;
    	for (Location x:this.locations) {
	    	summa+=x.getEnergyUse();
	    }
	    return summa;
    
    /**
     * Calculates the sum of all the children's area
     * @return The sum of the children's area
     */
    public int getArea() {
    	int areaSum = 0;
    	for (Location location: locations) {
    		areaSum += location.getArea();
    	}
    	return areaSum;
    }
    
    /**
     * Calculates the sum of all the children's volume
     * @return The sum of the children's volume
     */
    public int getCube() {
    	int cubeSum = 0;
    	for (Location location: locations) {
    		cubeSum += location.getCube();
    	}
    	return cubeSum;
    }
}
