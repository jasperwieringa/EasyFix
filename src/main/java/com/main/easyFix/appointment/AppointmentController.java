package com.main.easyFix.appointment;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class AppointmentController {
  private final AppointmentService appointmentService;

//  @GetMapping("/appointment/{id}")
//  public String appointment(@PathVariable Long id, Model model) {
//    return "appointment";
//  }

//  @PostMapping("/appointment/add")
//  public String add(Authentication authentication, @Valid Appointment appointment, BindingResult result, Model model) {
//    String err = appointmentService.validateCreation(authentication, appointment);
//
//    if (!err.isEmpty()) {
//      ObjectError error = new ObjectError("globalError", err);
//      result.addError(error);
//    }
//
//    if (!result.hasErrors()) {
//      model.addAttribute("success_message", "Successfully added a new customer");
//    }
//
//    appointmentService.create(customer);
//    model.addAttribute("appointment", appointmentService.listAllCustomers());
//    return "appointment";
//  }
}
