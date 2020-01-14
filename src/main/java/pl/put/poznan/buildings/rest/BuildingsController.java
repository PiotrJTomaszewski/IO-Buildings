package pl.put.poznan.buildings.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.buildings.logic.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Class that processes requests to buildings API. All requests are to /locations/{id} or its child.
 * Building structure is given in body of request. Only POST requests are processed.
 * @author Marcin Zatorski
 */
@RestController
public class BuildingsController {

    private static final Logger logger = LoggerFactory.getLogger(BuildingsController.class);

    /**
     * Returns location with given id in building. Maps into POST to /locations/{id}
     * @param id Id of location
     * @param building Building to be searched for
     * @return Location with given id
     */
    @PostMapping("/locations/{id}")
    public Location postLocation(@PathVariable long id, @RequestBody Building building) {
        // log the parameters
        logger.debug(Long.toString(id));
        logger.debug(building.toString());
        return findById(building, id);
    }

    /**
     * Returns cumulative area of location given by id in building.
     * Processes POST to /locations/{id}/area. Returns one key value pair in
     * format ("area", value) - to look prettier when serialized to JSON.
     * @param id Id of location
     * @param building Building to be searched for
     * @return Cumulative area of location as one key value pair
     */
    @PostMapping(path = "/locations/{id}/area")
    public Map<String, Integer> postLocationArea(@PathVariable long id, @RequestBody Building building) {
        // log the parameters
        logger.debug(Long.toString(id));
        logger.debug(building.toString());
        return toKeyValue("area", findById(building, id).getArea());
    }

    /**
     * Returns cumulative cube of given location with id in building.
     * Handles POST requests to /locations/{id}/cube. Returns key value
     * to be serialized into JSON.
     * @param id Id of location
     * @param building Building to be searched for
     * @return Cumulative cube as key value pair in format ("cube", cumulative cube)
     */
    @PostMapping(path = "/locations/{id}/cube")
    public Map<String, Integer> postLocationCube(@PathVariable long id, @RequestBody Building building) {
        // log the parameters
        logger.debug(Long.toString(id));
        logger.debug(building.toString());
        return toKeyValue("cube", findById(building, id).getCube());
    }

    /**
     * Returns mean light per area of location. Maps into POST to /locations/{id}/light
     * @param id Id of location
     * @param building Building that contains given location
     * @return Light per area of location as key value pair: ("light", value)
     */
    @PostMapping(path = "/locations/{id}/light")
    public Map<String, Float> postLocationLight(@PathVariable long id, @RequestBody Building building) {
        // log the parameters
        logger.debug(Long.toString(id));
        logger.debug(building.toString());
        return toKeyValue("light", (float) findById(building, id).getMeanLight());
    }

    /**
     * Returns heating energy consumption per cube of location. Handles POST to /locations/{id}/heating
     * @param id Id of location
     * @param building Bulding that contains given location
     * @return Heating energy consumption per cube as key value pair in format ("heating", value)
     */
    @PostMapping(path = "/locations/{id}/heating")
    public Map<String, Float> postLocationHeating(@PathVariable long id, @RequestBody Building building) {
        // log the parameters
        logger.debug(Long.toString(id));
        logger.debug(building.toString());
        return toKeyValue("heating", findById(building, id).getHeatingEnergyUse());
    }

    /**
     * Function that returns rooms that exceed given heating energy consumption per volume.
     * Maps into /location/{id}/exceed and handles POST requests.
     * @param id Id of location
     * @param heatingEnergy Heating energy per volume - request parameter
     * @param building Building that contains location
     * @return List of rooms that exceed given heating energy consumption per volume
     */
    @PostMapping(path = "/locations/{id}/exceed")
    public List<Location> postLocationExceed(@PathVariable long id, @RequestParam float heatingEnergy, @RequestBody Building building) {
        // log the parameters
        logger.debug(Long.toString(id));
        logger.debug(Float.toString(heatingEnergy));
        logger.debug(building.toString());
        return findById(building, id).thresholding_energy(heatingEnergy);
    }

    /**
     * Helper function that returns location with given id in building
     * or throws LocationNotFoundException if it was not found
     * @param building Building which is searched for location
     * @param id Id of location
     * @return Location with given id
     */
    private Location findById(Building building, long id) {
        LocationFinder finder = new LocationFinder(id);        
        building.accept(finder);        
        Location result = finder.getResult();
        if (result == null) {
            throw new LocationNotFoundException(id);
        }
        return result;
    }

    /**
     * Generic helper function that returns key value pair as map with one element.
     * Key is always a String.
     * @param key String that is a key
     * @param value Value
     * @param <T> Type of value
     * @return Map with one element
     */
    private <T> Map<String, T> toKeyValue(String key, T value) {
        Map<String, T> map = new HashMap<>();
        map.put(key, value);
        return map;
    }
}
