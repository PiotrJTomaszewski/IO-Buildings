package pl.put.poznan.buildings.logic;

/**
 * Represents a building
 *
 */
public class Building extends CompositeLocation {

    /**
     * Accepts a visitor and dispatches operation to it
     * @param visitor A visitor to accept
     */
    public void accept(LocationVisitor visitor) {
        visitor.visit(this);
    }
}
