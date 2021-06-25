package com.main.easyFix.appointment;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class AppointmentController {
  private final AppointmentService appointmentService;

  @PostMapping("/customer/{id}/add_appointment")
  public String add(Authentication authentication, @PathVariable int id, Appointment appointment) throws IllegalAccessException {
    appointmentService.add(authentication, appointment, id);
    return "redirect:/customer/" + id;
  }

  @PostMapping("/customer/{id}/update_appointment")
  public String update(Authentication authentication, @PathVariable int id, Appointment appointment) throws IllegalAccessException {
    appointmentService.update(authentication, appointment);
    return "redirect:/customer/" + id;
  }
}
