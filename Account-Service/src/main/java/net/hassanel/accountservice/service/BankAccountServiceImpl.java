package net.hassanel.accountservice.service;

import net.hassanel.accountservice.clients.CustomerRestClient;
import net.hassanel.accountservice.dtos.BankAccountDTO;
import net.hassanel.accountservice.entities.BankAccount;
import net.hassanel.accountservice.enums.AccountType;
import net.hassanel.accountservice.mappers.BankAccountMapperImpl;
import net.hassanel.accountservice.model.Customer;
import net.hassanel.accountservice.repositories.BankAccountRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BankAccountServiceImpl implements BankAccountService{

    private BankAccountRepository bankAccountRepository;
    private BankAccountMapperImpl dtoMapper;
    private CustomerRestClient customerRestClient;

    public BankAccountServiceImpl(BankAccountRepository bankAccountRepository, BankAccountMapperImpl dtoMapper, CustomerRestClient customerRestClient) {
        this.bankAccountRepository = bankAccountRepository;
        this.dtoMapper = dtoMapper;
        this.customerRestClient = customerRestClient;
    }

    @Override
    public BankAccountDTO addNewBankAccount(double initialBalance, String Currency,AccountType type, Long customerId) {

        BankAccount bankAccount=new BankAccount();
        bankAccount.setAccountId(UUID.randomUUID().toString());
        bankAccount.setType(type);
        bankAccount.setBalance(initialBalance);
        bankAccount.setCurrency(Currency);
        bankAccount.setCreatAt(LocalDate.now());
        bankAccount.setCustomerId(customerId);
       // bankAccount.setCustomer(customerRestClient.findCustomerById(customerId));
        BankAccount savedAccount=bankAccountRepository.save(bankAccount);

        return dtoMapper.fromBankAccount(savedAccount);
    }

    @Override
    public BankAccountDTO getBankAccount(String accountId) {
        BankAccount bankAccount = bankAccountRepository.findById(accountId).orElse(null);

        BankAccountDTO bankAccountDTO = dtoMapper.fromBankAccount(bankAccount);
        return bankAccountDTO;
    }

    @Override
    public List<BankAccountDTO> listBankAccount() {
        List<BankAccount>bankAccounts=bankAccountRepository.findAll();
        List<BankAccountDTO>bankAccountDTOS=bankAccounts.stream()
                .map(bank -> dtoMapper.fromBankAccount(bank)).collect(Collectors.toList());

        return bankAccountDTOS;
    }
}
