package cars_and_details.detail;


import cars_and_details.car.CarRepo;
import cars_and_details.car.model.Car;
import cars_and_details.detail.model.Detail;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DetailServiceImpl implements DetailService{
    private final DetailRepo detailRepo;

    @Override
    public Detail saveDetails(Detail detail) {
       return detailRepo.save(detail);
    }
}
