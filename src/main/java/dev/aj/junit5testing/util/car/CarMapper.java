package dev.aj.junit5testing.util.car;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface CarMapper {
    @Mapping(target = "seatCount", ignore = true)
    CarDto carToDto(Car car);

    @Mapping(target = "manufacturingDate", dateFormat = "dd/MM/yyyy")
    @Mapping(target = "numberOfSeats", ignore = true)
    Car dtoToCar(CarDto carDto);
}
