package com.main.easyFix.appointment;

import com.main.easyFix.customer.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class AppointmentController {
  private final CustomerService customerService;
  private final AppointmentService appointmentService;

  @GetMapping("/customer/{id}")
  public String customer(@PathVariable Long id, Model model) {
    model.addAttribute("customer", customerService.loadCustomerById(id));
    return "customer";
  }

  @PostMapping("/appointment/add")
  public String add(Authentication authentication, @Valid Appointment appointment, BindingResult result, Model model) {
    String err = appointmentService.validateCreation(authentication, appointment);
    Long customerId = appointment.getCustomer().getId();

    if (!err.isEmpty()) {
      ObjectError error = new ObjectError("globalError", err);
      result.addError(error);
    }

    if (!result.hasErrors()) {
      model.addAttribute("success_message", "Successfully added a new customer");
    }

    appointmentService.create(appointment);
    model.addAttribute("customer", customerService.loadCustomerById(customerId));
    return "customer";
  }
}
