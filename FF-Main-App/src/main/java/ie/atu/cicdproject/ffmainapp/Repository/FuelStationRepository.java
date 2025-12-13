package ie.atu.cicdproject.ffmainapp.Repository;

import ie.atu.cicdproject.ffmainapp.Model.FuelStationInformation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FuelStationRepository
        extends JpaRepository<FuelStationInformation, Long> {

    List<FuelStationInformation> findByStationNameIgnoreCase(String stationName);
}
