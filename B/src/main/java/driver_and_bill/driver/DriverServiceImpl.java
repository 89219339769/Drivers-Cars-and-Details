package driver_and_bill.driver;

import driver_and_bill.driver.DriverService;
import driver_and_bill.driver.model.Driver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService {

    private final DriverRepo driverRepo;

    @Override
    public Driver saveCar(Driver driver) {
        return driverRepo.save(driver);
    }
}
