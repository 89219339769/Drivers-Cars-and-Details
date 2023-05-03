package cars_and_details.car;


import cars_and_details.car.model.Car;
import cars_and_details.car.model.CarDto;
import cars_and_details.car_detail.CarDetailsService;
import cars_and_details.detail.DetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;
    private final CarDetailsService carDetailsService;
    @PostMapping
    public CarDto create(@RequestBody Car car) {


        return carService.saveCar(car);
    }



    @PostMapping("/{carId}/{detailId}")
    public CarDto addDetails (@PathVariable Long carId, @PathVariable Long detailId) {


        return carDetailsService.addDetails(carId, detailId);
    }




}
