package net.hassanel.accountservice.mappers;

import net.hassanel.accountservice.dtos.BankAccountDTO;
import net.hassanel.accountservice.entities.BankAccount;
import net.hassanel.accountservice.enums.AccountType;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class BankAccountMapperImpl {


   public BankAccountDTO fromBankAccount(BankAccount bankAccount){
       BankAccountDTO bankAccountDTO=new BankAccountDTO();
       bankAccountDTO.setAccountId(UUID.randomUUID().toString());
       bankAccountDTO.setType(bankAccount.getType());
       bankAccountDTO.setBalance(bankAccount.getBalance());
       bankAccountDTO.setCurrency(bankAccount.getCurrency());
       bankAccountDTO.setCreatAt(LocalDate.now());
       bankAccountDTO.setCustomerId(bankAccount.getCustomerId());

       return bankAccountDTO;
   }
    public BankAccount fromBankAccountDTO(BankAccountDTO bankAccountDTO) {
        BankAccount bankAccount = new BankAccount();
        BeanUtils.copyProperties(bankAccountDTO, bankAccount);

        return bankAccount;
    }
}
