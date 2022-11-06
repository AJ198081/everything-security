package dev.aj.junit5testing.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDto {
    private long customerId;
    private String fullName, dateOfBirth, title;
    private double creditScore;
    private AddressDto addressDto;
}
