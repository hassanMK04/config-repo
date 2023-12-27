package net.hassanel.accountservice.web;

import net.hassanel.accountservice.clients.CustomerRestClient;
import net.hassanel.accountservice.entities.BankAccount;
import net.hassanel.accountservice.model.Customer;
import net.hassanel.accountservice.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class test {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private CustomerRestClient customerRestClient;
    @GetMapping(path = "/test")
    Customer bankAccountList() {
       Customer customer = customerRestClient.findCustomerById(1L);
        return customer;
    }
}
