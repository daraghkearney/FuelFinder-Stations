package ie.atu.cicdproject.ffmainapp.Service;

import ie.atu.cicdproject.ffmainapp.Model.FuelStationInformation;
import ie.atu.cicdproject.ffmainapp.errorHandling.NoStationsFoundException;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FuelStationService {

    private final List<FuelStationInformation> stations = new ArrayList<>();

    public List<FuelStationInformation> getAll()  {
        return stations;
    }

       public List<FuelStationInformation> search(String location) {
           List<FuelStationInformation> results =stations.stream()
                   .filter(s -> s.getLocation().equalsIgnoreCase(location))
                   .collect(Collectors.toList());


        if (results.isEmpty()) {
            throw new NoStationsFoundException("No fuel stations found in " + location);
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
