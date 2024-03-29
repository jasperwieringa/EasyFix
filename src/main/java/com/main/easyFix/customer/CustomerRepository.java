package com.main.easyFix.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
  Optional<Customer> findById(int id);
  Optional<Customer> findByEmail(String email);
  List<Customer> findAll();
}
