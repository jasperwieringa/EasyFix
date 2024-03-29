package com.main.easyFix.appointment;

import com.main.easyFix.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
  Optional<Appointment> findById(int id);
  Appointment findByCustomer(Customer customer);
  List<Appointment> findAll();
}
