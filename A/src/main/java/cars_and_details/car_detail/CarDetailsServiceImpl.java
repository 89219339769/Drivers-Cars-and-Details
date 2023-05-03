package cars_and_details.car_detail;

import cars_and_details.car.CarRepo;
import cars_and_details.car.model.Car;
import cars_and_details.car.model.dto.CarDto;
import cars_and_details.car.model.CarMapping;
import cars_and_details.car_detail.model.CarDetail;
import cars_and_details.detail.DetailRepo;
import cars_and_details.detail.model.Detail;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CarDetailsServiceImpl implements CarDetailsService {
private final CarDetailRepo carDetailRepo;
private final CarRepo carRepo;

private final DetailRepo detailRepo;

    @Override
    public CarDto addDetails(Long carId, Long detailId) {

        Car car = carRepo.findById(carId)
                                  .orElseThrow(() -> new RuntimeException("не найден пользователь с id: " + carId));
        Detail detail = detailRepo.findById(detailId)
                                  .orElseThrow(() -> new RuntimeException("не найден пользователь с id: " + detailId));

        CarDetail carDetail = new CarDetail();
        carDetail.setCar(car);
        carDetail.setDetail(detail);

        carDetailRepo.save(carDetail);

        List<Detail> detailList =  carDetailRepo.findCarDetailByCar(car.getId());

        CarDto carDto = CarMapping.toCarDto(car);
        carDto.setDetails(detailList);

        return carDto;
    }
}
