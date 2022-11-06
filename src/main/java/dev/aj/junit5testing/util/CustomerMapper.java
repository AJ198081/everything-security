package dev.aj.junit5testing.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(uses = AddressMapper.class, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CustomerMapper {

    @Mapping(target = "customerId", source = "id")
    @Mapping(target = "dateOfBirth", dateFormat = "dd/MM/yyyy")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "fullName", expression = "java(customer.getFirstName()  + customer.getLastName())")
    CustomerDto customerToDto(Customer customer);

    @Mapping(target = "id", source = "customerId")
    @Mapping(target = "customerType", ignore = true)
    @Mapping(target = "address", source = "addressDto")
    @Mapping(target = "firstName", ignore = true)
    @Mapping(target = "lastName", ignore = true)
    Customer dtoToCustomer(CustomerDto customerDto);

    //User Java 8 default method to map types between source and target, be picked up automatically
    default String toString(Title title) {
        return title.getValue();
    }
}
