package driver_and_bill.driver;


import cars_and_details.car.model.dto.DriverDto;
import cars_and_details.detail.Type;
import driver_and_bill.bill.Bill;
import driver_and_bill.bill.TypeM;
import driver_and_bill.driver.model.Driver;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/drivers")
public class DriverController {

    private final DriverService driverService;

    @PostMapping
    public Driver create(@RequestBody DriverDto driver) {
        return driverService.saveCar(driver);
    }

    @PostMapping("bill/{driverId}")
    public Bill createBill (@RequestBody Bill bill, @PathVariable Long driverId) {


        return driverService.saveBill(bill, driverId);
    }




    @PatchMapping("bill/{driverId}/increase")
    public Bill increaseBill (@PathVariable Long driverId, @RequestParam(required = true) Double sum,
                              @RequestParam(required = true) String type) {


        return driverService.increase (driverId, sum, type);
    }

    @GetMapping("/{driverId}")
    public DriverDto getDriverById(@PathVariable Long driverId) {
        return driverService.getDriverById(driverId);
    }

}
