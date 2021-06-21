package com.main.easyFix.appointment;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppointmentService {
  private final AppointmentRepository appointmentRepository;

  public Appointment loadAppointmentByCustomerId(Long id) {
    return appointmentRepository.findByCustomerId(id);
  }

  public Appointment add(Appointment appointment) {
    appointmentRepository.save(appointment);
    return appointment;
  }
}
