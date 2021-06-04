package com.main.easyFix.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface CustomerRepository extends JpaRepository<Customer, Long> {
  Optional<Customer> findByLastName(String lastName);
  Optional<Customer> findByPostalCode(String postalCode);
  Optional<Customer> findByEmail(String email);
}
