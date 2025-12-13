package ie.atu.cicdproject.ffmainapp.Service;

import ie.atu.cicdproject.ffmainapp.Model.FuelStationInformation;
import ie.atu.cicdproject.ffmainapp.Repository.FuelStationRepository;
import ie.atu.cicdproject.ffmainapp.errorHandling.NoStationsFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuelStationService {

    private final FuelStationRepository repository;

    public FuelStationService(FuelStationRepository repository) {
        this.repository = repository;
    }

    public List<FuelStationInformation> getAll() {
        return repository.findAll();
    }

    // Search stations by station name
    public List<FuelStationInformation> searchByStation(String station) {

        List<FuelStationInformation> results =
                repository.findByStationNameIgnoreCase(station);

        if (results.isEmpty()) {
            throw new NoStationsFoundException(
                    "No fuel stations found with station name: " + station
            );
        }

        return results;
    }

    public FuelStationInformation add(FuelStationInformation station) {
        return repository.save(station);
    }

    public int count() {
        return (int) repository.count();
    }
}
