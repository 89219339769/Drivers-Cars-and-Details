package driver_and_bill.driver.model;

import cars_and_details.car.model.Car;
import cars_and_details.car.model.dto.CarDto;
import cars_and_details.car.model.dto.DriverDto;

public class DriverMapper {

    public static Driver toCarDto(DriverDto driver) {
        return Driver
                .builder()
                .carLicenseCategory(driver.getCarLicenseCategory())
                .fullName(driver.getFullName())
                .dateOfBirth(driver.getDateOfBirth())
                .passport(driver.getPassport())
                .build();
    }

}
