package dev.aj.junit5testing.util.car;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarDto {

    private String make, manufacturingDate, category, model;
    private int seatCount;
    private double price;

}
