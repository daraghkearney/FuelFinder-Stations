package ie.atu.cicdproject.ffmainapp.Service;

import ie.atu.cicdproject.ffmainapp.Model.FuelStationInformation;
import ie.atu.cicdproject.ffmainapp.errorHandling.NoStationsFoundException;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FuelStationService {

    private final List<FuelStationInformation> stations = new ArrayList<>();

    public List<FuelStationInformation> getAll() {
        return stations;
    }

    // Search stations by station name
    public List<FuelStationInformation> searchByStation(String station) {

        List<FuelStationInformation> results = stations.stream()
                .filter(s -> s.getStationName().equalsIgnoreCase(station))
                .collect(Collectors.toList());

        if (results.isEmpty()) {
            throw new NoStationsFoundException("No fuel stations found with station name: " + station);
        }

        return results;
    }

    public FuelStationInformation add(FuelStationInformation station) {
        stations.add(station);
        return station;
    }

    public int count() {
        return stations.size();
    }
}
