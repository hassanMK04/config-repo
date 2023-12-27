package net.hassanel.accountservice.repositories;

import net.hassanel.accountservice.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
}
