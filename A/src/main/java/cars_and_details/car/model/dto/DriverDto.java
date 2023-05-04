package cars_and_details.car.model.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

@Data
@Builder
public class DriverDto  {


    private Long id;


    private String fullName;



    private String passport;


    private String carLicenseCategory;


    private LocalDate dateOfBirth;


    private Integer drivingExperience;


    private Long carId;

}
