package net.hassanel.customerservice.repositories;

import net.hassanel.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

//@RestResource
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
