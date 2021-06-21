package com.main.easyFix.customer;

import com.main.easyFix.appointment.Appointment;
import com.main.easyFix.appointment.AppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class CustomerController {
  private final CustomerService customerService;
  private final AppointmentService appointmentService;

  @GetMapping("/customers")
  public String customers(Customer customer, Model model) {
    model.addAttribute("customers", customerService.listAllCustomers());
    return "customers";
  }

  @GetMapping("/customer/{id}")
  public String customer(@PathVariable Long id, Model model) {
    Customer customer = customerService.loadCustomerById(id);
    Appointment appointment = appointmentService.loadAppointmentByCustomerId(id);

    // Ensure that the Appointment Model exists within the Thymeleaf form
    if (appointment == null) {
      appointment = new Appointment();
    }

    model.addAttribute("customer", customer);
    model.addAttribute("appointment", appointment);
    return "customer";
  }

  @PostMapping("/customers/add")
  public String addCustomer(Authentication authentication, @Valid Customer customer, BindingResult result, Model model) {
    String response = customerService.register(authentication, customer);

    if (!response.equals("OK")) {
      ObjectError error = new ObjectError("globalError", response);
      result.addError(error);
    }

    if (!result.hasErrors()) {
      model.addAttribute("success_message", "Successfully added a new customer");
    }

    model.addAttribute("customers", customerService.listAllCustomers());
    return "customers";
  }

  @RequestMapping(value="/customers/remove/{id}", method = RequestMethod.DELETE)
  public String removeCustomer(Authentication authentication, Customer customer, @PathVariable Long id, BindingResult result, Model model) {
    String response = customerService.remove(authentication, id);

    if (!response.equals("OK")) {
      ObjectError error = new ObjectError("globalError", response);
      result.addError(error);
    }

    if (!result.hasErrors()) {
      model.addAttribute("success_message", "Customer successfully removed");
    }

    model.addAttribute("customers", customerService.listAllCustomers());
    return "customers";
  }

  @PostMapping("/customer/{id}/appointment/add")
  public String addAppointment(Authentication authentication, @PathVariable Long id, Appointment appointment, BindingResult result, Model model) {
    String response = customerService.addAppointment(authentication, appointment, id);

    if (!response.equals("OK")) {
      ObjectError error = new ObjectError("globalError", response);
      result.addError(error);
    }

    if (!result.hasErrors()) {
      model.addAttribute("success_message", "Successfully added a new appointment");
    }

    model.addAttribute("customer", customerService.loadCustomerById(id));
    return "customer";
  }

//  public String updateAppointment() {}
}
