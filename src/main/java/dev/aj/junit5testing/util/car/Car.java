package dev.aj.junit5testing.util.car;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Car {

    private String make;
    private int numberOfSeats;
    private LocalDate manufacturingDate;
    private BigDecimal price;
    private Category category;
    private Model model;

}
