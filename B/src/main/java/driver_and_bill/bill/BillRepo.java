package driver_and_bill.bill;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BillRepo  extends JpaRepository<Bill, Long> {



    @Query("select b from Bill b  where   b.driver.id = 1 " +
            "order by b.id")
    Bill findBillByDriverId(Long driverId);
}

