package ie.atu.cicdproject.ffmainapp;

import ie.atu.cicdproject.ffmainapp.errorHandling.NoStationsFoundException;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/stations")
public class FuelStationController {

    private List<FuelStationInformation> stations = new ArrayList<>();

    // Add a new fuel station
    @PostMapping("/add")
    public FuelStationInformation addStation(@Valid @RequestBody FuelStationInformation station) {
        stations.add(station);
        return station;
    }

    // Get all stations
    @GetMapping("/getAll")
    public List<FuelStationInformation> getAllStations() {
        return stations;
    }

    // Search stations by location (e.g. "Galway City")
    @GetMapping("/search")
    public List<FuelStationInformation> searchByLocation(@RequestParam String location) {

        List<FuelStationInformation> results = stations.stream()
                .filter(s -> s.getLocation().equalsIgnoreCase(location))
                .collect(Collectors.toList());
        if (results.isEmpty()) {
            throw new NoStationsFoundException("No fuel stations found in " + location);
        }
        return results;
    }

    // Count total stations
    @GetMapping("/count")
    public int countStations() {
        return stations.size();
    }
}
