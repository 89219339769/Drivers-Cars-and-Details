package cars_and_details.car.model;

public class CarMapping {


    public static CarDto toCarDto(Car car) {
        return CarDto
                .builder()
                .vin(car.getVin())
                .number(car.getNumber())
                .creator(car.getCreator())
                .yearOfManufacture(car.getYearOfManufacture())
                .build();
    }

}
