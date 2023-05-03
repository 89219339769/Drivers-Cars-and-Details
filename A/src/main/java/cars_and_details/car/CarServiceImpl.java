package cars_and_details.car;


import cars_and_details.car.model.Car;
import cars_and_details.car.model.dto.CarDto;
import cars_and_details.car.model.CarMapping;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepo carRepo;

    @Override
    public CarDto saveCar(Car car) {
        carRepo.save(car);

        CarDto carDto = CarMapping.toCarDto(car);

        return carDto;
    }

//    @Override
//    public CarDto addDetails(Long carId, Long detailId) {
//
//
//        return null;
//    }
}
