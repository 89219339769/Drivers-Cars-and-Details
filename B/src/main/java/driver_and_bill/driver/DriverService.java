package driver_and_bill.driver;

import cars_and_details.car.model.dto.DriverDto;
import driver_and_bill.bill.Bill;
import driver_and_bill.driver.model.Driver;

public interface DriverService {
    Driver saveDriver(DriverDto driver);

    DriverDto getDriverById(Long driverId);

    Bill saveBill(Bill bill, Long driverId);

    Bill increase(Long driverId, Double sum, String type);

    Bill  getBillByDriverId(Long driverId,  String type);

    Bill reduce(Long driverId, Double sum, String type);
}
