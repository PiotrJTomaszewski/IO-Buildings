package pl.put.poznan.buildings.logic;

public class Building extends CompositeLocation {

    public void accept(LocationVisitor visitor) {
        visitor.visit(this);
    }
}
