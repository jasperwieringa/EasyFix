package com.main.easyFix.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface OrderRepository extends JpaRepository<Order, Long> {
  Optional<Order> findById(Long id);
  Optional<Order> findByCustomerId(Long id);
  List<Order> findAll();
}
