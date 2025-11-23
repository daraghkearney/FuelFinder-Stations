package ie.atu.cicdproject.ffmainapp.Model;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;



@Data
@AllArgsConstructor

public class FuelStationInformation {

    @NotBlank(message = "Station name is required")
    private String stationName;

    @DecimalMin(value = "1.0", message = "Petrol price must be more than or equal to €1")
    private double petrolPrice;

    @DecimalMin(value = "1.0", message = "Diesel price must be more than or equal to €1")
    private double dieselPrice;

    @NotBlank(message = "Location is required")
    private String location;



}
