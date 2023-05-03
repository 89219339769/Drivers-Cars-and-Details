package cars_and_details.client;


import cars_and_details.car.model.dto.DriverDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/drivers")
public class DriverController {


    private final DriverClient appClient;
    @PostMapping
    public ResponseEntity<Object> postUser(@RequestBody DriverDto application) {

        return appClient.postDriver(application);
    }


}
