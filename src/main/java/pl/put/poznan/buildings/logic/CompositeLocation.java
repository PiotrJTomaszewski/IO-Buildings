package pl.put.poznan.buildings.logic;

import java.util.List;

public abstract class CompositeLocation extends Location {
    private List<Location> locations;
    
    public int getArea() {
    	int areaSum = 0;
    	for (Location location: locations) {
    		areaSum += location.getArea();
    	}
    	return areaSum;
    }
}
