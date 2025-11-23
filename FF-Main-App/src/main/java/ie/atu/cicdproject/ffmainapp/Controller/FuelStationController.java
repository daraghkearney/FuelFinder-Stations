package ie.atu.cicdproject.ffmainapp.Controller;

import ie.atu.cicdproject.ffmainapp.Model.FuelStationInformation;
import ie.atu.cicdproject.ffmainapp.Service.FuelStationService;
import ie.atu.cicdproject.ffmainapp.errorHandling.NoStationsFoundException;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/stations")
public class FuelStationController {

    private final FuelStationService service;

    public FuelStationController(FuelStationService service) {
        this.service = service;
    }


    // Add a new fuel station
    @PostMapping("/add")
    public FuelStationInformation addStation(@Valid @RequestBody FuelStationInformation station) {
        return service.add(station);
    }

    // Get all stations
    @GetMapping("/getAll")
    public List<FuelStationInformation> getAllStations()
    {
        return service.getAll();
    }

    // Search stations by location (e.g. "Galway City")
    @GetMapping("/search")
    public List<FuelStationInformation> search(@RequestParam String location) {
        return service.search(location);
    }

    // Count total stations
    @GetMapping("/count")
    public int countStations()
    {
        return service.count();
    }
}
