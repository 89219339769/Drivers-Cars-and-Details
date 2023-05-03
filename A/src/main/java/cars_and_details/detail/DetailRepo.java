package cars_and_details.detail;

import cars_and_details.car.model.Car;
import cars_and_details.detail.model.Detail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailRepo extends JpaRepository<Detail, Long> {


}

