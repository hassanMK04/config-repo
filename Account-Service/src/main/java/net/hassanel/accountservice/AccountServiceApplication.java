package net.hassanel.accountservice;

import net.hassanel.accountservice.clients.CustomerRestClient;
import net.hassanel.accountservice.dtos.BankAccountDTO;
import net.hassanel.accountservice.enums.AccountType;
import net.hassanel.accountservice.service.BankAccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner star(BankAccountService bankAccountService, CustomerRestClient customerRestClient){
        return args -> {
            customerRestClient.customers().forEach(c -> {
                bankAccountService.addNewBankAccount(Math.random()*147000,"MAD", AccountType.SAVING_ACCOUNT, c.getId());
                bankAccountService.addNewBankAccount(Math.random()*180000,"USD", AccountType.CURRENT_ACCOUNT,c.getId());

            });
            /*bankAccountService.addNewBankAccount(147000,"MAD", AccountType.SAVING_ACCOUNT,1L);
            bankAccountService.addNewBankAccount(180000,"USD", AccountType.CURRENT_ACCOUNT,2L);
            bankAccountService.addNewBankAccount(147000,"EUR", AccountType.SAVING_ACCOUNT,3L);*/
        };
    }

}
