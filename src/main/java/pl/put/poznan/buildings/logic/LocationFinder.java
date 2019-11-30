package pl.put.poznan.buildings.logic;

public class LocationFinder implements LocationVisitor {
    private long locationId;
    private Location result;

    public LocationFinder(long locationId) {
        this.locationId = locationId;
    }

    @Override
    public void visit(Room room) {
        if (room.getId() == locationId) {
            result = room;
        }
    }

    @Override
    public void visit(Building building) {
        visit((CompositeLocation) building);
    }

    public void visit(CompositeLocation location) {
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

    public Location getResult() {
        return result;
    }
}
