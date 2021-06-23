package com.main.easyFix.details;

import com.main.easyFix.appointment.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface DetailRepository extends JpaRepository<Detail, Long> {
  List<Detail> findByAppointment(Appointment appointment);
}
