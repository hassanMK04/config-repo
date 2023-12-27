package net.hassanel.customerservice.service;

import net.hassanel.customerservice.dtos.CustomerRequestDTO;
import net.hassanel.customerservice.dtos.CustomerResponseDTO;
import net.hassanel.customerservice.entities.Customer;
import net.hassanel.customerservice.mappers.CustomerMapper;
import net.hassanel.customerservice.repositories.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional

public class customerServiceImpl implements CustomerService{
        private CustomerRepository customerRepository;
        private CustomerMapper customerMapper;

    public customerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerResponseDTO addCustomer(CustomerRequestDTO customerRequestDTO) {

        Customer customer=customerMapper.CustomerRequestDTOToCustomer(customerRequestDTO);
        Customer savedCustomer=customerRepository.save(customer);
        CustomerResponseDTO customerResponseDTO=customerMapper.CustomerToCustomerResponseDTO(savedCustomer);
        return customerResponseDTO;


    }

    @Override
    public CustomerResponseDTO getCustomer(Long id) {
        Customer customer=customerRepository.findById(id).get();
        CustomerResponseDTO customerResponseDTO=customerMapper.CustomerToCustomerResponseDTO(customer);
        return customerResponseDTO;
    }

    @Override
    public List<CustomerResponseDTO> fullCustomers() {
        List<Customer>customers=customerRepository.findAll();
        List<CustomerResponseDTO>customerResponseDTOS=customers.stream()
                .map(customer -> customerMapper.CustomerToCustomerResponseDTO(customer)).collect(Collectors.toList());
        return customerResponseDTOS;
    }

    @Override
    public CustomerResponseDTO updateCustomer(CustomerRequestDTO customerRequestDTO) {
        Customer customer=customerMapper.CustomerRequestDTOToCustomer(customerRequestDTO);
        Customer savedCustomer=customerRepository.save(customer);
        CustomerResponseDTO customerResponseDTO=customerMapper.CustomerToCustomerResponseDTO(savedCustomer);
        return customerResponseDTO;
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);

    }
}
