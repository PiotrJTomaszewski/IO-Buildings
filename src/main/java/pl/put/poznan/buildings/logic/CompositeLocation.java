package pl.put.poznan.buildings.logic;

import java.util.ArrayList;
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
    public float getHeatingEnergyUse() {
	    float summa=this.getHeating()/this.getCube();
	    return summa;
    }
    
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
     * Calculates the sum of all the children's heating
     * @return The sum of the children's heating
     */
    public float getHeating() {
    	int heatSum = 0;
    	for (Location location: locations) {
    		heatSum += location.getArea();
    	}
    	return heatSum;
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
    
    /**
     * Calculates the sum of all the children's light
     * @return The sum of the children's light
     */
    public int getLight() {
    	int lightSum = 0;
    	for (Location location: locations) {
    		lightSum += location.getLight();
    	}
    	return lightSum;
    }
    
    /**
     * Calculates the mean of all the children's light
     * @return The sum of the children's light divided by the sum of the children's volume
     */
    public float getMeanLight() {
    	float lightMean = 0;
    	lightMean = this.getLight() / this.getArea();
    	return lightMean;
    }
    
    /**
     * gives all rooms using more energy than threshold
     * 
     * @return list of all buildings above threshold
     * @author sebastian_michon
     */
    public ArrayList<Location> thresholding_energy(float thr){
    	ArrayList<Location> thresholded_list=new ArrayList<>();
    	
    	for (Location x: locations) {
    		ArrayList<Location> subbuild=x.thresholding_energy(thr);
    		for (Location y: subbuild) {
    			thresholded_list.add(y);
    		}
    	}
    	return thresholded_list;
    };
    
}
