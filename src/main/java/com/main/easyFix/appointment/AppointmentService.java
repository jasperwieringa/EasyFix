package com.main.easyFix.appointment;

import com.main.easyFix.utils.PermissionValidator;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppointmentService {
  private final static String ORDER_NOT_FOUND_MSG = "Order with id %s not found";
  private final AppointmentRepository appointmentRepository;

  public Appointment loadAppointmentById(Long id) throws NotFoundException {
    return appointmentRepository.findById(id).orElseThrow(() ->
      new NotFoundException(String.format(ORDER_NOT_FOUND_MSG, id)));
  }

  public Appointment loadAppointmentByCustomerId(Long id) throws NotFoundException {
    return appointmentRepository.findByCustomerId(id).orElseThrow(() ->
      new NotFoundException(String.format(ORDER_NOT_FOUND_MSG, id)));
  }

  public void create(Appointment appointment) {
    appointmentRepository.save(appointment);
  }

  public String validateCreation(Authentication authentication, Appointment appointment) {
    if (!PermissionValidator.isAdmin(authentication)) {
      return "Permission denied";
    }
    return "";
  }
}
