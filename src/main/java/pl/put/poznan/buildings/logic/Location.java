package pl.put.poznan.buildings.logic;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = Room.class, name = "room"),
    @JsonSubTypes.Type(value = Building.class, name = "building"),
    @JsonSubTypes.Type(value = Floor.class, name = "floor")
})
/**
 * Represents a location.
 *
 */
public abstract class Location {
	/**
	 * Identification number of the location.
	 */
    private long id;
    /**
     * The name of the location.
     */
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public abstract float getHeatingEnergyUse();
    public abstract float getHeating();
    public abstract int getArea();
    public abstract int getLight();
    public abstract float getMeanLight();
    public abstract ArrayList<Location> thresholding_energy(float thr);
    public abstract int getCube();
    
    /**
     * Accepts a visitor and dispatches operation to it.
     * @param visitor A visitor to accept
     */
    public abstract void accept(LocationVisitor visitor);

    @Override
    public String toString() {
        return String.format("Building id:%d name:%s", id, name);
    }

}
