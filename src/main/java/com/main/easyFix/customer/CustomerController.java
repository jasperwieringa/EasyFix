package com.main.easyFix.customer;

import com.main.easyFix.appointment.Appointment;
import com.main.easyFix.appointment.AppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    Appointment appointment = customer.getAppointment();

    // Ensure that the Appointment Model exists within the Thymeleaf form
    if (appointment == null) {
      appointment = new Appointment();
    }

    model.addAttribute("customer", customer);
    model.addAttribute("appointment", appointment);
    return "customer";
  }

  @PostMapping("/customers/add")
  public String add(Authentication authentication, @Valid Customer customer, Model model) throws IllegalAccessException {
    customerService.add(authentication, customer);
    model.addAttribute("customers", customerService.listAllCustomers());
    return "customers";
  }

  @RequestMapping(value="/customers/remove/{id}", method = RequestMethod.DELETE)
  public String remove(Authentication authentication, Customer customer, @PathVariable Long id, Model model) throws IllegalAccessException {
    customerService.remove(authentication, id);
    model.addAttribute("customers", customerService.listAllCustomers());
    return "customers";
  }
}
