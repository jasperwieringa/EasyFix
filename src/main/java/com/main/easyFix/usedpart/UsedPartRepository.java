package com.main.easyFix.usedpart;

import com.main.easyFix.appointment.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface UsedPartRepository extends JpaRepository<UsedPart, Integer> {
  Optional<UsedPart> findById(int id);
  public List<UsedPart> findByAppointment(Appointment appointment);
}
