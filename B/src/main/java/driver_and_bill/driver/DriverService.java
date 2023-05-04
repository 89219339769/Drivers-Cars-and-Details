package driver_and_bill.driver;

import cars_and_details.car.model.dto.DriverDto;
import cars_and_details.detail.Type;
import driver_and_bill.bill.Bill;
import driver_and_bill.bill.TypeM;
import driver_and_bill.driver.model.Driver;

public interface DriverService {
    Driver saveCar(DriverDto driver);

    DriverDto getDriverById(Long driverId);

    Bill saveBill(Bill bill, Long driverId);

    Bill increase(Long driverId, Double sum, String type);
}
