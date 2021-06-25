package com.main.easyFix.usedpart;

import com.main.easyFix.appointment.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface UsedPartRepository extends JpaRepository<UsedPart, Integer> {
  public List<UsedPart> findByAppointment(Appointment appointment);
}
