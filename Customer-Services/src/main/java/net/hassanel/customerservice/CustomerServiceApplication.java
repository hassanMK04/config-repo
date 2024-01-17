package net.hassanel.customerservice;


import net.hassanel.customerservice.dtos.CustomerRequestDTO;

import net.hassanel.customerservice.service.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;

@SpringBootApplication

public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerService customerService){
        return args -> {

            customerService.addCustomer(new CustomerRequestDTO(null,"Elquaouri","hassan","hassan@el.com"));
            customerService.addCustomer(new CustomerRequestDTO(null,"yahya","yahya","yahya@ma.com"));
            customerService.addCustomer(new CustomerRequestDTO(null,"malak","malak","malak@ma.com"));
        };
    }

}
