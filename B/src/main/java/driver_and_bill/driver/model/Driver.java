package driver_and_bill.driver.model;

import cars_and_details.car.model.Car;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "drivers")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", length = 100, nullable = false)
    private String fullName;


    @Column(length = 100, nullable = false)
    private String passport;

    @Column(name = "car_license_category", length = 1, nullable = false)
    private String carLicenseCategory;

    @Column(name = "date_of_Birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "driving_experience", nullable = false)
    private Integer drivingExperience;


    @Column(name = "car_id")
    private Long carId;

}
