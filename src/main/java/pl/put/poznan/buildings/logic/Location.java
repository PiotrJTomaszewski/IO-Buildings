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
    @JsonSubTypes.Type(value = Building.class, name = "building")
})
public abstract class Location {
    private long id;
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
    public abstract ArrayList<Location> thresholding_energy(float thr);
    public abstract int getCube();

    public abstract void accept(LocationVisitor visitor);

    @Override
    public String toString() {
        return String.format("Building id:%d name:%s", id, name);
    }

}
