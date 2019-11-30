package pl.put.poznan.buildings.rest;

/**
 * Exception thrown when location given by id has not been found.
 */
public class LocationNotFoundException extends RuntimeException {
    public LocationNotFoundException(long id) {
        super("Could not find location " + id);
    }
}
