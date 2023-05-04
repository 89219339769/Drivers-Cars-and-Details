package cars_and_details.car;


import cars_and_details.car.model.Car;
import cars_and_details.car.model.dto.CarDto;

public interface CarService {
    CarDto saveCar(Car car);


    Car findById(Long carId);
}
