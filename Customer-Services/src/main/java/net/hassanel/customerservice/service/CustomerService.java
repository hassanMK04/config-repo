package net.hassanel.customerservice.service;

import net.hassanel.customerservice.dtos.CustomerRequestDTO;
import net.hassanel.customerservice.dtos.CustomerResponseDTO;

import java.util.List;

public interface CustomerService {
    CustomerResponseDTO addCustomer(CustomerRequestDTO customerRequestDTO);
    CustomerResponseDTO getCustomer(Long id);
    List<CustomerResponseDTO> fullCustomers();
    CustomerResponseDTO updateCustomer(CustomerRequestDTO customerRequestDTO);
    void deleteCustomer(Long id);
}
