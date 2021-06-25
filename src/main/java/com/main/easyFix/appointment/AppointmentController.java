package com.main.easyFix.appointment;

import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@AllArgsConstructor
public class AppointmentController {
  private final AppointmentService appointmentService;

  @PostMapping("/customer/{customer_id}/add_appointment")
  public String add(Authentication authentication, @PathVariable int customer_id, Appointment appointment) throws IllegalAccessException {
    appointmentService.add(authentication, appointment, customer_id);
    return "redirect:/customer/" + customer_id;
  }

  @PostMapping("/customer/{customer_id}/update_appointment")
  public String update(Authentication authentication, @PathVariable int customer_id, Appointment appointment) throws IllegalAccessException {
    appointmentService.update(authentication, appointment, customer_id);
    return "redirect:/customer/" + customer_id;
  }

  @RequestMapping(value="/customer/{customer_id}/remove_appointment", method = RequestMethod.DELETE)
  public String remove(Authentication authentication, @PathVariable int customer_id) throws IllegalAccessException, NotFoundException {
    appointmentService.remove(authentication, customer_id);
    return "redirect:/customer/" + customer_id;
  }
}
