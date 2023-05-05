package cars_and_details.client;


import cars_and_details.car.CarService;
import cars_and_details.car.model.Car;
import cars_and_details.car.model.dto.DriverDto;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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


    @PostMapping
    public ResponseEntity<Object> postDriver(@RequestBody DriverDto driverDto) {
        return driverClient.postDriver(driverDto);
    }


    @GetMapping("/{driverId}")
    public ResponseEntity<Object> getDriver(@PathVariable Long driverId) {

        ResponseEntity<Object> driverDto = driverClient.getDriver(driverId);
        return driverDto;
    }




}



