package pl.put.poznan.buildings.logic;

public class Floor extends CompositeLocation {

    @Override
    public void accept(LocationVisitor visitor) {
        visitor.visit(this);
    }
}
