package pl.put.poznan.buildings.logic;

/**
 * Represents a floor
 *
 */
public class Floor extends CompositeLocation {

    /**
     * Accepts a visitor and dispatches operation to it
     * @param visitor A visitor to accept
     */
    @Override
    public void accept(LocationVisitor visitor) {
        visitor.visit(this);
    }
}
