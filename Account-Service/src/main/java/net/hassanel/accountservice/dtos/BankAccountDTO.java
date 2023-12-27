package net.hassanel.accountservice.dtos;

import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.hassanel.accountservice.enums.AccountType;
import net.hassanel.accountservice.model.Customer;

import java.time.LocalDate;


@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class BankAccountDTO {

    private String AccountId;
    private LocalDate creatAt;
    private String Currency;
    private AccountType type;
    private double Balance;

    private Customer customer;
    private Long customerId;

}
