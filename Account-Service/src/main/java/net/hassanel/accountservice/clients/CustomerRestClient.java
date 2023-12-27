package net.hassanel.accountservice.clients;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import net.hassanel.accountservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient(name = "CUSTOMER-SERVICES")
public interface CustomerRestClient {
    @GetMapping(path = "/customers/{customerId}")
    @CircuitBreaker(name = "customerService",fallbackMethod = "getDefaultCustomer")
    Customer findCustomerById(@PathVariable Long customerId);
    @GetMapping(path = "/customers")
    @CircuitBreaker(name = "customerService",fallbackMethod = "DefaultAllCustomers")
    List<Customer>customers();

default Customer getDefaultCustomer(Long id,Exception exception){
    Customer customer=new Customer();
    customer.setId(id);
    customer.setFirstName("no available");
    customer.setLastName("no available");
    customer.setEmail("no available");
    return customer;
}
default List<Customer>DefaultAllCustomers(Exception exception){
    return List.of();
}
}
