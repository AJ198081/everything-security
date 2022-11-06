package dev.aj.junit5testing.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    private long id;
    private String firstName, lastName;
    private Title title;
    private LocalDate dateOfBirth;
    private BigDecimal creditScore;
    private CustomerType customerType;
    private Address address;
}
