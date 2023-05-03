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

    @Override
    public Detail updateDetails(Detail detail) {

        Detail detailForUpdate = detailRepo.findById(detail.getId())
                                           .orElseThrow(() -> new RuntimeException("не найдена деталь с id: " + detail.getId()+
                                                   "обновить нельзя"));
        detailForUpdate.setType(detail.getType());
        detailForUpdate.setSerialNumber(detail.getSerialNumber());
        return detailRepo.save(detail);
    }
}
