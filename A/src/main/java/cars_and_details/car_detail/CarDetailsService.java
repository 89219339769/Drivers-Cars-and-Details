package cars_and_details.car_detail;

import cars_and_details.car.model.dto.CarDto;

public interface CarDetailsService {
    CarDto addDetails(Long carId, Long detailId);
}
