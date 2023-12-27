package net.hassanel.accountservice.web;

import net.hassanel.accountservice.clients.CustomerRestClient;
import net.hassanel.accountservice.entities.BankAccount;
import net.hassanel.accountservice.model.Customer;
import net.hassanel.accountservice.repositories.BankAccountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
//@RequestMapping("/api")
public class BankAccountRestController {

    private BankAccountRepository bankAccountRepository;


    private CustomerRestClient customerRestClient;

    public BankAccountRestController(BankAccountRepository bankAccountRepository, CustomerRestClient customerRestClient) {
        this.bankAccountRepository = bankAccountRepository;
        this.customerRestClient = customerRestClient;
    }


    @PostMapping("/account")
    BankAccount addNewBankAccount(@RequestBody BankAccount bankAccount){
        return bankAccountRepository.save(bankAccount);
    }
    @GetMapping(path = "/account")
    List<BankAccount> bankAccountList(){

        List<BankAccount> accountList = bankAccountRepository.findAll();
        accountList.forEach(acc->{
            acc.setCustomer(customerRestClient.findCustomerById(acc.getCustomerId()));
        });
        return accountList;
    }
    @GetMapping(path = "/accounts/{id}")
    BankAccount AccountById(@PathVariable String id){

        BankAccount bankAccount = bankAccountRepository.findById(id).get();
        Customer customer=customerRestClient.findCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        return bankAccount;
    }
}
