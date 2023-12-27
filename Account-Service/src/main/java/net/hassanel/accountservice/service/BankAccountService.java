package net.hassanel.accountservice.service;

import net.hassanel.accountservice.dtos.BankAccountDTO;
import net.hassanel.accountservice.enums.AccountType;

import java.util.List;

public interface BankAccountService {

    BankAccountDTO addNewBankAccount(double initialBalance, String Currency, AccountType type,Long customerId);
    BankAccountDTO getBankAccount(String accountId);
    List<BankAccountDTO> listBankAccount();
}
