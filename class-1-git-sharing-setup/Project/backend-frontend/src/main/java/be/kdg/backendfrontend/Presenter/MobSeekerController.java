package be.kdg.backendfrontend.Presenter;

import be.kdg.backendfrontend.Calculation.PathFinder;
import be.kdg.backendfrontend.Domain.Data;
import be.kdg.backendfrontend.Service.DataService;
import be.kdg.backendfrontend.Service.DeviceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MobSeekerController {
    private DataService dataService;
    private DeviceService deviceService;
    private Logger LOGGER = LoggerFactory.getLogger(MobSeekerController.class);

    public MobSeekerController(DataService dataService,
                               DeviceService deviceService) {
        this.dataService = dataService;
        this.deviceService = deviceService;
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        double longitudeMOB = dataService.returningLongitude(dataService.findDataById(1));
        double latitudeMOB = dataService.returningLatitude(dataService.findDataById(1));
        double longitudeVictim = dataService.returningLongitude(dataService.findDataById(2));
        double latitudeVictim = dataService.returningLatitude(dataService.findDataById(2));
        PathFinder pathFinder = new PathFinder(4.403,  51.22, 45);
        LOGGER.info("LongitudeMOB: " + longitudeMOB);
        LOGGER.info("LatitudeMOB: " + latitudeMOB);
        LOGGER.info("LongitudeVictim: " + longitudeVictim);
        LOGGER.info("LatitudeVictim: " + latitudeVictim);
        LOGGER.info("PathFinderX: " + pathFinder.calculateIntersectX(pathFinder));
        LOGGER.info("PathFinderY: " + pathFinder.calculateIntersectY(pathFinder));
        model.addAttribute("MOBlongitude", longitudeMOB);
        model.addAttribute("MOBlatitude", latitudeMOB);
        model.addAttribute("longitudeVictim", longitudeVictim);
        model.addAttribute("latitudeVictim", latitudeVictim);
        model.addAttribute("pathFinderX", pathFinder.calculateIntersectX(pathFinder));
        model.addAttribute("pathFinderY", pathFinder.calculateIntersectY(pathFinder));
        return "admin";
    }

    @GetMapping("/team")
    public String team() {
        return "team";
    }

    @GetMapping("project")
    public String project() {
        return "project";
    }

}
