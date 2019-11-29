package pl.put.poznan.buildings.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.buildings.logic.Building;
import pl.put.poznan.buildings.logic.Location;
import pl.put.poznan.buildings.logic.Room;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class BuildingsController {

    private static final Logger logger = LoggerFactory.getLogger(BuildingsController.class);

    @PostMapping("/locations/{id}")
    public Building postLocation(@PathVariable long id, @RequestBody Building building) {
        // log the parameters
        logger.debug(Long.toString(id));
        logger.debug(building.toString());
        return building;
    }

    @PostMapping(path = "/locations/{id}/area")
    public Map<String, Integer> postLocationArea(@PathVariable long id, @RequestBody Building building) {
        // log the parameters
        logger.debug(Long.toString(id));
        logger.debug(building.toString());
        return toKeyValue("area", building.getArea());
    }

    @PostMapping(path = "/locations/{id}/cube")
    public Map<String, Integer> postLocationCube(@PathVariable long id, @RequestBody Building building) {
        // log the parameters
        logger.debug(Long.toString(id));
        logger.debug(building.toString());
        return toKeyValue("cube", building.getCube());
    }

    @PostMapping(path = "/locations/{id}/light")
    public Map<String, Float> postLocationLight(@PathVariable long id, @RequestBody Building building) {
        // log the parameters
        logger.debug(Long.toString(id));
        logger.debug(building.toString());
        return toKeyValue("light", building.getMeanLight());
    }

    @PostMapping(path = "/locations/{id}/heating")
    public Map<String, Float> postLocationHeating(@PathVariable long id, @RequestBody Building building) {
        // log the parameters
        logger.debug(Long.toString(id));
        logger.debug(building.toString());
        return toKeyValue("heating", building.getHeatingEnergyUse());
    }

    @PostMapping(path = "/locations/{id}/exceed")
    public List<Location> postLocationSuboptimal(@PathVariable long id, @RequestParam float heatingEnergy, @RequestBody Building building) {
        // log the parameters
        logger.debug(Long.toString(id));
        logger.debug(Float.toString(heatingEnergy));
        logger.debug(building.toString());
        return building.thresholding_energy(heatingEnergy);
    }

    private <T> Map<String, T> toKeyValue(String key, T value) {
        Map<String, T> map = new HashMap<>();
        map.put(key, value);
        return map;
    }
}
