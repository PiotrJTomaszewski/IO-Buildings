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
    }
}
