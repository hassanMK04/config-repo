package net.hassanel.accountservice.web;

import net.hassanel.accountservice.clients.CustomerRestClient;
import net.hassanel.accountservice.dtos.BankAccountDTO;
import net.hassanel.accountservice.enums.AccountType;
import net.hassanel.accountservice.service.BankAccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*@RestController
public class AccountRestController {
    private BankAccountService bankAccountService;
    private CustomerRestClient customerRestClient;

    public AccountRestController(BankAccountService bankAccountService, CustomerRestClient customerRestClient) {
        this.bankAccountService = bankAccountService;
        this.customerRestClient = customerRestClient;
    }
    @PostMapping(path = "/account")
    public BankAccountDTO addNewBankAccount(double initialBalance, String Currency, AccountType type, Long customerId) {
        return bankAccountService.addNewBankAccount(initialBalance, Currency, type, customerId);
    }
    @GetMapping("/account/{accountId}")
   public BankAccountDTO findAccountById(@PathVariable String accountId){
        return bankAccountService.getBankAccount(accountId);
   }
    @GetMapping(path = "/account")
    public List<BankAccountDTO> listBankAccount() {

        return bankAccountService.listBankAccount();
    }
}
        */