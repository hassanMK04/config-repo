package net.hassanel.customerservice.mappers;

import net.hassanel.customerservice.dtos.CustomerRequestDTO;
import net.hassanel.customerservice.dtos.CustomerResponseDTO;
import net.hassanel.customerservice.entities.Customer;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerResponseDTO CustomerToCustomerResponseDTO(Customer customer);
    Customer CustomerRequestDTOToCustomer(CustomerRequestDTO customerRequestDTO);
}
