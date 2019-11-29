package pl.put.poznan.buildings.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.buildings.logic.Building;


@RestController
public class BuildingsController {

    private static final Logger logger = LoggerFactory.getLogger(BuildingsController.class);

    @PostMapping("/buildings/{buildingId}")
    public Building postBuilding(@PathVariable long buildingId, @RequestBody Building building) {
        // log the parameters
        logger.debug(Long.toString(buildingId));
        logger.debug(building.toString());
        return building;
    }

    @PostMapping("/buildings/{buildingId}/levels/{levelId}")
    public Building postBuilding(@PathVariable long buildingId, @PathVariable long levelId, @RequestBody Building building) {
        // log the parameters
        logger.debug(Long.toString(buildingId));
        logger.debug(Long.toString(levelId));
        logger.debug(building.toString());
        return building;
    }

    @PostMapping("/buildings/{buildingId}/levels/{levelId}/rooms/{roomId}")
    public Building postBuilding(@PathVariable long buildingId, @PathVariable long levelId, @PathVariable long roomId, @RequestBody Building building) {
        // log the parameters
        logger.debug(Long.toString(buildingId));
        logger.debug(Long.toString(levelId));
        logger.debug(Long.toString(roomId));
        logger.debug(building.toString());
        return building;
    }
}


