package com.main.easyFix.usedpart;

import com.main.easyFix.appointment.Appointment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UsedPartService {
  private final UsedPartRepository usedPartRepository;

  public List<UsedPart> loadUsedPartsByAppointment(Appointment appointment) {
    return usedPartRepository.findByAppointment(appointment);
  }
}
