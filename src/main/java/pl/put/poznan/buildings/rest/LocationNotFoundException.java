package pl.put.poznan.buildings.rest;

public class LocationNotFoundException extends RuntimeException {
    public LocationNotFoundException(long id) {
        super("Could not find location " + id);
    }
}
