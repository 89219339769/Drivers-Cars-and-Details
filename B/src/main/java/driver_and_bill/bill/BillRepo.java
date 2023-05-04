package driver_and_bill.bill;

import driver_and_bill.driver.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepo  extends JpaRepository<Bill, Long> {
}

