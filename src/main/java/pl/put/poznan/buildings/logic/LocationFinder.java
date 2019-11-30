package pl.put.poznan.buildings.logic;

/**
 * Class that finds location with given id.
 */
public class LocationFinder implements LocationVisitor {
    private long locationId;
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
