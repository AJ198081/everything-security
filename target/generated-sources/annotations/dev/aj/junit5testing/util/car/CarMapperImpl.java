package dev.aj.junit5testing.util.car;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-06T11:40:04+1100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
public class CarMapperImpl implements CarMapper {

    private final DateTimeFormatter dateTimeFormatter_dd_MM_yyyy_0650712384 = DateTimeFormatter.ofPattern( "dd/MM/yyyy" );

    @Override
    public CarDto carToDto(Car car) {
        if ( car == null ) {
            return null;
        }

        CarDto.CarDtoBuilder carDto = CarDto.builder();

        carDto.make( car.getMake() );
        if ( car.getManufacturingDate() != null ) {
            carDto.manufacturingDate( DateTimeFormatter.ISO_LOCAL_DATE.format( car.getManufacturingDate() ) );
        }
        if ( car.getCategory() != null ) {
            carDto.category( car.getCategory().name() );
        }
        if ( car.getModel() != null ) {
            carDto.model( car.getModel().name() );
        }
        if ( car.getPrice() != null ) {
            carDto.price( car.getPrice().doubleValue() );
        }

        return carDto.build();
    }

    @Override
    public Car dtoToCar(CarDto carDto) {
        if ( carDto == null ) {
            return null;
        }

        Car.CarBuilder car = Car.builder();

        if ( carDto.getManufacturingDate() != null ) {
            car.manufacturingDate( LocalDate.parse( carDto.getManufacturingDate(), dateTimeFormatter_dd_MM_yyyy_0650712384 ) );
        }
        car.make( carDto.getMake() );
        car.price( BigDecimal.valueOf( carDto.getPrice() ) );
        if ( carDto.getCategory() != null ) {
            car.category( Enum.valueOf( Category.class, carDto.getCategory() ) );
        }
        if ( carDto.getModel() != null ) {
            car.model( Enum.valueOf( Model.class, carDto.getModel() ) );
        }

        return car.build();
    }
}
