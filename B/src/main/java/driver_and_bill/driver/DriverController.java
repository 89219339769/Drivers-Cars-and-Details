package driver_and_bill.driver;


import cars_and_details.car.model.dto.DriverDto;
import driver_and_bill.bill.Bill;
import driver_and_bill.driver.model.Driver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/drivers")
public class DriverController {

    private final DriverService driverService;
private final DriverRepo driverRepo; //потом стереть
    //сохраняем водителя
    @PostMapping
    public Driver create(@RequestBody DriverDto driver) {
        return driverService.saveDriver(driver);
    }

    //прикреаляем счет к водителю
    @PostMapping("bill/{driverId}")
    public Bill createBill(@RequestBody Bill bill, @PathVariable Long driverId) {


        return driverService.saveBill(bill, driverId);
    }


    //начисляем средства водителю
    @PatchMapping("bill/{driverId}/increase")
    public Bill increaseBill(@PathVariable Long driverId, @RequestParam(required = true) Double sum,
                             @RequestParam(required = true) String type) {


        return driverService.increase(driverId, sum, type);
    }


    //снимаем средства водителю
    @PatchMapping("bill/{driverId}/reduce")
    public Bill reduceBill(@PathVariable Long driverId, @RequestParam(required = true) Double sum,
                           @RequestParam(required = true) String type) {


        return driverService.reduce(driverId, sum, type);
    }


    //получаем информацию по  водителю
    @GetMapping("/{driverId}")
    public DriverDto getDriverById(@PathVariable Long driverId) {
        return driverService.getDriverById(driverId);
    }


    //получаем информацию по счету водителя
    @GetMapping("bill/{driverId}")
    public Bill getBillByDriverId(@PathVariable Long driverId, @RequestParam(required = true) String type) {
        return driverService.getBillByDriverId(driverId, type);
    }
}
