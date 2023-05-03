package cars_and_details.car.model.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Data
public class DriverDto {


    private Long id;


    private String fullName;



    private String passport;


    private String carLicenseCategory;


    private LocalDate dateOfBirth;


    private Integer drivingExperience;


    private Integer carId;

}
