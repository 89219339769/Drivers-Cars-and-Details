package cars_and_details.car.model;

import cars_and_details.detail.model.Detail;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {


    private String vin;


    private String number;


    private String creator;


    private int yearOfManufacture;

    private List<Detail> details;


}
