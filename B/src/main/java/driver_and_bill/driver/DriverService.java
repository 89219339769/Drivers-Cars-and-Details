package driver_and_bill.driver;

import cars_and_details.car.model.dto.DriverDto;
import driver_and_bill.bill.Bill;
import driver_and_bill.driver.model.Driver;

public interface DriverService {
    Driver saveCar(DriverDto driver);

    DriverDto getDriverById(Long driverId);

    Bill saveBill(Bill bill, Long driverId);
}
