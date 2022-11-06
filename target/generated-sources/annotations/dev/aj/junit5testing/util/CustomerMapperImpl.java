package dev.aj.junit5testing.util;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-06T11:40:04+1100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    private final DateTimeFormatter dateTimeFormatter_dd_MM_yyyy_0650712384 = DateTimeFormatter.ofPattern( "dd/MM/yyyy" );

    @Override
    public CustomerDto customerToDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDto.CustomerDtoBuilder customerDto = CustomerDto.builder();

        customerDto.customerId( customer.getId() );
        if ( customer.getDateOfBirth() != null ) {
            customerDto.dateOfBirth( dateTimeFormatter_dd_MM_yyyy_0650712384.format( customer.getDateOfBirth() ) );
        }
        customerDto.title( toString( customer.getTitle() ) );
        if ( customer.getCreditScore() != null ) {
            customerDto.creditScore( customer.getCreditScore().doubleValue() );
        }

        customerDto.fullName( customer.getFirstName()  + customer.getLastName() );

        return customerDto.build();
    }

    @Override
    public Customer dtoToCustomer(CustomerDto customerDto) {
        if ( customerDto == null ) {
            return null;
        }

        Customer.CustomerBuilder customer = Customer.builder();

        customer.id( customerDto.getCustomerId() );
        customer.address( addressDtoToAddress( customerDto.getAddressDto() ) );
        if ( customerDto.getTitle() != null ) {
            customer.title( Enum.valueOf( Title.class, customerDto.getTitle() ) );
        }
        if ( customerDto.getDateOfBirth() != null ) {
            customer.dateOfBirth( LocalDate.parse( customerDto.getDateOfBirth() ) );
        }
        customer.creditScore( BigDecimal.valueOf( customerDto.getCreditScore() ) );

        return customer.build();
    }

    protected Address addressDtoToAddress(AddressDto addressDto) {
        if ( addressDto == null ) {
            return null;
        }

        Address.AddressBuilder address = Address.builder();

        address.number( addressDto.getNumber() );
        address.street( addressDto.getStreet() );
        address.suburb( addressDto.getSuburb() );
        address.state( addressDto.getState() );
        address.postCode( addressDto.getPostCode() );

        return address.build();
    }
}
