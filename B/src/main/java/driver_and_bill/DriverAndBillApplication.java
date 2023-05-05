package driver_and_bill;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class DriverAndBillApplication {

    public static void main(String[] args) {
        SpringApplication.run(DriverAndBillApplication.class, args);
    }

}
