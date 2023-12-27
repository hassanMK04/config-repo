package net.hassanel.customerservice.web;

import net.hassanel.customerservice.dtos.CustomerRequestDTO;
import net.hassanel.customerservice.dtos.CustomerResponseDTO;
import net.hassanel.customerservice.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class CustomerRestController {

    private CustomerService customerService;

    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @PostMapping("/customers")
    public CustomerResponseDTO addCustomer(@RequestBody CustomerRequestDTO customerRequestDTO) {
        return customerService.addCustomer(customerRequestDTO);
    }
    @GetMapping("/customers/{id}")
    public CustomerResponseDTO getCustomer(@PathVariable Long id) {
        return customerService.getCustomer(id);
    }
   @GetMapping("/customers")
    public List<CustomerResponseDTO> fullCustomers() {
        return customerService.fullCustomers();
    }
    @PutMapping("/customers")
    public CustomerResponseDTO updateCustomer(CustomerRequestDTO customerRequestDTO) {
        return customerService.updateCustomer(customerRequestDTO);
    }
    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }
}
