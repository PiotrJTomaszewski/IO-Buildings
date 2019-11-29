package pl.put.poznan.buildings.logic;

public abstract class Location {
    private long id;
    private String name;

    public Location() {

    }

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
    
    public abstract int getArea();
    
    public abstract int getCube();

    @Override
    public String toString() {
        return String.format("Building id:%d name:%s", id, name);
    }
}