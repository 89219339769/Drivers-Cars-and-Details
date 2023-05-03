package cars_and_details.car_detail;

import cars_and_details.car.model.Car;
import cars_and_details.car_detail.model.CarDetail;
import cars_and_details.detail.model.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarDetailRepo extends JpaRepository<CarDetail, Long> {

    @Query("select c.detail from CarDetail c  where   c.car.id = 1 " +
            "order by c.id")
    List<Detail> findCarDetailByCar(Long carId);
}

