package driver_and_bill.driver;
import driver_and_bill.driver.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface DriverRepo extends JpaRepository<Driver, Long> {

//    @Query("select d from Driver d     WHERE d.dateOfBirth = 1 " +
//            "order by d.id" )
//    List<Driver> getDriversByDate(LocalDate date);


    @Query(value = "SELECT * FROM Drivers d   WHERE DATE(date_of_birth) = ?1", nativeQuery = true)
    List<Driver> getDriversByDate(LocalDate date);


}
