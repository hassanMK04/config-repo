package net.hassanel.accountservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.hassanel.accountservice.enums.AccountType;
import net.hassanel.accountservice.model.Customer;

import java.time.LocalDate;
@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class BankAccount {
    @Id
    private String AccountId;
    private LocalDate creatAt;
    private String Currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    private double Balance;
    private Long customerId;
    @Transient
    private Customer customer;
}
