package driver_and_bill.driver;

import cars_and_details.car.model.dto.DriverDto;
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

    @Override
    public Driver saveCar(DriverDto driver) {
        return driverRepo.save(DriverMapper.toCarDto(driver));
    }
}
