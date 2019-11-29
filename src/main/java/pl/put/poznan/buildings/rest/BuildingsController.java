package pl.put.poznan.buildings.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.buildings.logic.Building;


@RestController
public class BuildingsController {

    private static final Logger logger = LoggerFactory.getLogger(BuildingsController.class);

    @PostMapping("/buildings")
    public Building postBuilding(@RequestBody Building building) {
        // log the parameters
        logger.debug(building.toString());
        return building;
    }
}


