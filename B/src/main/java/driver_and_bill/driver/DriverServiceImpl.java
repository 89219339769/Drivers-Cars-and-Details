package driver_and_bill.driver;

import cars_and_details.car.model.dto.DriverDto;
import driver_and_bill.bill.Bill;
import driver_and_bill.bill.BillRepo;
import driver_and_bill.bill.TypeM;
import driver_and_bill.driver.model.Driver;
import driver_and_bill.driver.model.DriverMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService {

    private final DriverRepo driverRepo;
    private final BillRepo billRepo;


    @Override
    public Driver saveDriver(DriverDto driver) {
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
        if (type.equals(TypeM.RED.toString().toLowerCase())) {
            return saveSumInc(driverId, sum);
        }

        if (type.equals(TypeM.GREEN.toString().toLowerCase())) {
            sum = sum * 2.5;
            return saveSumInc(driverId, sum);
        }

        if (type.equals(TypeM.BLUE.toString().toLowerCase())) {
            sum = sum * 2.5 * 0.6;
            return saveSumInc(driverId, sum);
        }
        throw new RuntimeException("неверный тип валюты");
    }

    @Override
    public Bill getBillByDriverId(Long driverId, String type) {
        Bill bill = billRepo.findBillByDriverId(driverId);
        if (type.equals(TypeM.RED.toString().toLowerCase())) {
            return bill;
        }
        if (type.equals(TypeM.GREEN.toString().toLowerCase())) {
            double sum = bill.getSum();
            sum = sum * 2.5;
            bill.setSum(sum);
            return bill;
        }
        if (type.equals(TypeM.BLUE.toString().toLowerCase())) {
            double sum = bill.getSum();
            sum = sum * 2.5 * 0.6;
            bill.setSum(sum);
            return bill;
        }
        throw new RuntimeException("неверный тип валюты");
    }

    @Override
    public Bill reduce(Long driverId, Double sum, String type) {
        Bill bill = billRepo.findBillByDriverId(driverId);

        if (type.equals(TypeM.RED.toString().toLowerCase())) {
            saveSumRed(bill, sum);
        }
        if (type.equals(TypeM.GREEN.toString().toLowerCase())) {
            sum = sum * 2.5;
            saveSumRed(bill, sum);
        }
        if (type.equals(TypeM.BLUE.toString().toLowerCase())) {
            sum =  sum * 2.5 * 0.6;
            saveSumRed(bill, sum);
        }
        throw new RuntimeException("неверный тип валюты");
    }


    private Bill saveSumInc(Long driverId, Double sum) {
        Bill bill = billRepo.findBillByDriverId(driverId);
        double sumCur = bill.getSum();
        sumCur += sum;
        bill.setSum(sumCur);
        return billRepo.save(bill);
    }

    private Bill saveSumRed(Bill bill, Double sum) {
        double sumBill = bill.getSum();
        if (sum > sumBill) {
            throw new RuntimeException("на счету недостаточно средств");
        }
        sumBill -= sum;
        bill.setSum(sumBill);
        return billRepo.save(bill);
    }


    //поздравляем водителя с днем рождения
    @Scheduled(fixedRate = 86400000)
    public void BirthCongDriverTest() {
        LocalDate date = LocalDate.now();
        List<Driver> drivers =  driverRepo.getDriversByDate(date);
        for (Driver driver:drivers){
            log.debug("happy birthday " + driver.getFullName());
        }
    }


}





