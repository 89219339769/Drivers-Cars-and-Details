package cars_and_details.car_detail.model;


import cars_and_details.car.model.Car;
import cars_and_details.detail.model.Detail;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "cars_details")
@AllArgsConstructor
@NoArgsConstructor
public class CarDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id", nullable = false)
    private Car car;

    @ManyToOne
    @JoinColumn(name = "detail_id", referencedColumnName = "id", nullable = false)
    private Detail detail;
}
