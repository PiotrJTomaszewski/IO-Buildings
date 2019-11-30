package pl.put.poznan.buildings.logic;

public interface LocationVisitor {
    public void visit(Room room);
    public void visit(Building building);
}
