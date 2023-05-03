package cars_and_details.car;


import cars_and_details.car.model.Car;
import cars_and_details.car.model.CarDto;

public interface CarService {
    CarDto saveCar(Car car);

    CarDto addDetails(Long carId, Long detailId);
}
