package pl.put.poznan.buildings.logic;

/**
 * Interface for visitor objects that operate on locations.
 */
public interface LocationVisitor {
    public void visit(Room room);
    public void visit(Building building);
    public void visit(Floor floor);
}
