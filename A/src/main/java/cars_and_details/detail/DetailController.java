package cars_and_details.detail;

import cars_and_details.car.CarService;
import cars_and_details.car.model.Car;
import cars_and_details.detail.model.Detail;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/details")
public class DetailController {

    private final DetailService detailService;

    //создание детали
    @PostMapping
    public Detail create(@RequestBody Detail detail) {
        return detailService.saveDetails(detail);
    }

    //замена детали
    @PutMapping
    public Detail update(@RequestBody Detail detail) {
        return detailService.updateDetails(detail);
    }


}
