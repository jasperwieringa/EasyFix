package com.main.easyFix.customer;

import com.main.easyFix.appointment.Appointment;
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

  @GetMapping("/customers")
  public String customers(Customer customer, Model model) {
    model.addAttribute("customers", customerService.listAllCustomers());
    return "customer/customers";
  }

  @GetMapping("/customers/{id}")
  public String customer(@PathVariable Long id, Model model) {
    Customer customer = customerService.loadCustomerById(id);
    Appointment appointment = customer.getAppointment();

    // Ensure that the Appointment Model exists within the Thymeleaf form
    if (appointment == null) {
      appointment = new Appointment();
    }

    model.addAttribute("customer", customer);
    model.addAttribute("appointment", appointment);
    return "customer/customer";
  }

  @PostMapping("/customers/add")
  public String add(Authentication authentication, @Valid Customer customer) throws IllegalAccessException {
    customerService.add(authentication, customer);
    return "redirect:/customers";
  }

//  @PostMapping("/customers/{id}/update")
//  public String update(Authentication authentication, Customer customer) throws IllegalAccessException {
//    customerService.update(authentication, customer);
//    return "redirect:/customers";
//  }

  @RequestMapping(value="/customers/{id}/remove", method = RequestMethod.DELETE)
  public String remove(Authentication authentication, @PathVariable Long id) throws IllegalAccessException {
    customerService.remove(authentication, id);
    return "redirect:/customers";
  }
}
