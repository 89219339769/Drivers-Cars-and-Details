package cars_and_details.client;


import cars_and_details.car.CarService;
import cars_and_details.car.model.Car;
import cars_and_details.car.model.dto.DriverDto;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Driver;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/drivers")
public class DriverController {


    private final DriverClient driverClient;
    private final CarService carService;


    //сохраняем водителя
    @PostMapping
    public ResponseEntity<Object> postDriver(@RequestBody DriverDto driverDto) {

        return driverClient.postDriver(driverDto);
    }


    //устанавливаем владение автомобилем
//    @PostMapping("/{driverId}/{carId}")
//    public ResponseEntity<Object> addCarToDriver(@PathVariable Long driverId, @PathVariable Long carId) {
//
//
//        carService.findById(carId);
//
//
//        ResponseEntity<Object> driverDto = driverClient.getDriver(driverId);
//
//        String driver = driverDto.getBody().toString();
//        String[] drivers = driver.split(",");
//        List<String> driversList = new ArrayList<>();
//        for (String de : drivers) {
//            String[] driversSpl = de.split("=");
//            driversList.add(driversSpl[1]);
//        }
//
//        DriverDto driverDto2 = DriverDto.builder()
//                                        .id(Long.valueOf(driversList.get(0)))
//                                        .fullName(driversList.get(1))
//                                        .passport(driversList.get(2))
//                                        .carLicenseCategory(driversList.get(3))
//                                        .dateOfBirth(LocalDate.parse(driversList.get(4)))
//                                        .drivingExperience(Integer.valueOf(driversList.get(5)))
//                                        .carId(carId)
//                                        .build();
//
//        driverClient.postDriver(driverDto2);
//        ResponseEntity<Object> driverDto3 = driverClient.getDriver(driverId);
//        return driverDto3;
//    }
}



