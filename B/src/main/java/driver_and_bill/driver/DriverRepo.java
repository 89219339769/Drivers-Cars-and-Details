package driver_and_bill.driver;

import cars_and_details.car.model.dto.DriverDto;
import cars_and_details.car_detail.model.CarDetail;
import driver_and_bill.driver.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepo extends JpaRepository<Driver, Long> {
}
