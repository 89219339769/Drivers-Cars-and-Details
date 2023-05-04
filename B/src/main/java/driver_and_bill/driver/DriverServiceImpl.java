package driver_and_bill.driver;

import cars_and_details.car.model.dto.DriverDto;
import driver_and_bill.bill.Bill;
import driver_and_bill.bill.BillRepo;
import driver_and_bill.driver.DriverService;
import driver_and_bill.driver.model.Driver;
import driver_and_bill.driver.model.DriverMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService {

    private final DriverRepo driverRepo;
    private final BillRepo billRepo;

    @Override
    public Driver saveCar(DriverDto driver) {
        return driverRepo.save(DriverMapper.toDriver(driver));
    }

    @Override
    public DriverDto getDriverById(Long driverId) {
        Driver driver = driverRepo.findById(driverId)
                                  .orElseThrow(() -> new RuntimeException("не найден водитель с id: " + driverId));
        return DriverMapper.toDriverDto(driver);
    }

    @Override
    public Bill saveBill(Bill bill, Long driverId) {

       Driver driver =  driverRepo.findById(driverId)
                                  .orElseThrow(() -> new RuntimeException("не найден водитель с id: " + driverId));

       bill.setDriver(driver);
       return billRepo.save(bill);

    }
}
