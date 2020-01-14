package pl.put.poznan.buildings.logic;

/**
 * Class that finds location with given id.
 */
public class LocationFinder implements LocationVisitor {
	/**
	 * Identification number of the location.
	 */
    private long locationId;
    
    /**
     * The result of location search.
     */
    private Location result;

    public LocationFinder(long locationId) {
        this.locationId = locationId;
    }

    /**
     * Checks if room has given id
     * @param room Room to process
     */
    @Override
    public void visit(Room room) {
        if (room.getId() == locationId) {
            result = room;
        }
    }

    /**
     * Finds location with given id either in building or its children.
     * @param building Building to process
     */
    @Override
    public void visit(Building building) {
        visit((CompositeLocation) building);
    }

    /**
     * Finds location with given id either in floor or its children.
     * @param floor Floor to process
     */
    @Override
    public void visit(Floor floor) {
        visit((CompositeLocation) floor);
    }
    
    /**
     * Finds location with given id in location or its children.
     * @param location Location to process
     */
    private void visit(CompositeLocation location) {
    	if (location.getId() == locationId) {
            result = location;
        }
        else {
            for (Location l : location.getLocations()) {
                l.accept(this);
                if (result != null) {
                    return;
                }
            }
        }
    }

    /**
     * Get location that was found.
     * @return Location if it was found, null otherwise
     */
    public Location getResult() {
        return result;
    }
}
