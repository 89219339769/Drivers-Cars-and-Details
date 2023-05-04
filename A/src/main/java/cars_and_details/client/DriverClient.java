package cars_and_details.client;


import cars_and_details.car.model.dto.DriverDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.util.DefaultUriBuilderFactory;



@Service
public class DriverClient extends BaseClient {

    private static final String API_PREFIX = "/drivers";


    @Autowired
    public DriverClient(@Value("${shareit-server.url}") String serverUrl, RestTemplateBuilder builder) {
        super(builder.uriTemplateHandler(new DefaultUriBuilderFactory(serverUrl + API_PREFIX))

                    .build());
    }

//    @Autowired
//    public ApplicationClient(@Value("${shareit-server.url}") String serverUrl, RestTemplateBuilder builder) {
//        super(builder.uriTemplateHandler(new DefaultUriBuilderFactory(serverUrl + API_PREFIX))
//                     .requestFactory(HttpComponentsClientHttpRequestFactory::new)
//                     .build());
//    }


    public ResponseEntity<Object> postDriver(DriverDto driverDto) {
        return post("", driverDto);
    }


    public ResponseEntity<Object> getDriver(Long driverId) {
         return get("/" + driverId);



    }

}
