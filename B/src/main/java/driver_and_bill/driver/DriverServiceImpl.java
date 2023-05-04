package driver_and_bill.driver;

import cars_and_details.car.model.dto.DriverDto;
import cars_and_details.detail.Type;
import driver_and_bill.bill.Bill;
import driver_and_bill.bill.BillRepo;
import driver_and_bill.bill.TypeM;
import driver_and_bill.driver.DriverService;
import driver_and_bill.driver.model.Driver;
import driver_and_bill.driver.model.DriverMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService {

    private final DriverRepo driverRepo;
    private final BillRepo billRepo;

    @Override
    public Driver saveCar(DriverDto driver) {
        return driverRepo.save(DriverMapper.toDriver(driver));
    }

    @Override
    public DriverDto getDriverById(Long driverId) {
        Driver driver = driverRepo.findById(driverId)
                                  .orElseThrow(() -> new RuntimeException("не найден водитель с id: " + driverId));
        return DriverMapper.toDriverDto(driver);
    }

    @Override
    public Bill saveBill(Bill bill, Long driverId) {

        Driver driver = driverRepo.findById(driverId)
                                  .orElseThrow(() -> new RuntimeException("не найден водитель с id: " + driverId));

        bill.setDriver(driver);
        return billRepo.save(bill);

    }

    @Override
    public Bill increase(Long driverId, Double sum, String type) {

        if (type.equals(TypeM.REED.toString().toLowerCase())) {
            Bill bill = billRepo.findBillByDriverId(driverId);
            double sumCur = bill.getSum();
            sumCur += sum;
            bill.setSum(sumCur);
            return billRepo.save(bill);
        }
        if (type.equals(TypeM.GREEN.toString().toLowerCase())) {
            sum = sum * 2.5;
            Bill bill = billRepo.findBillByDriverId(driverId);
            double sumCur = bill.getSum();
            sumCur += sum;
            bill.setSum(sumCur);
            return billRepo.save(bill);
        }

        if (type.equals(TypeM.BLUE.toString().toLowerCase())) {
            sum = sum * 2.5 * 0.6;
            Bill bill = billRepo.findBillByDriverId(driverId);
            double sumCur = bill.getSum();
            sumCur += sum;
            bill.setSum(sumCur);
            return billRepo.save(bill);
        }

        throw new RuntimeException("неверный тип валюты");

    }
}
