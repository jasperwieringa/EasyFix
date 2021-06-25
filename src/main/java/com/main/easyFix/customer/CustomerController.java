package com.main.easyFix.customer;

import com.main.easyFix.appointment.Appointment;
import com.main.easyFix.appointment.AppointmentService;
import com.main.easyFix.usedpart.UsedPart;
import com.main.easyFix.usedpart.UsedPartService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class CustomerController {
  private final CustomerService customerService;
  private final AppointmentService appointmentService;
  private final UsedPartService usedPartService;

  @GetMapping("/customers")
  public String customers(Customer customer, Model model) {
    model.addAttribute("customers", customerService.listAllCustomers());
    return "customer/customers";
  }

  @PostMapping("/customers/add")
  public String add(Authentication authentication, Customer customer) throws IllegalAccessException {
    customerService.add(authentication, customer);
    return "redirect:/customers";
  }

  @GetMapping("/customer/{customer_id}")
  public String customer(@PathVariable int customer_id, Model model) {
    Customer customer = customerService.loadCustomerById(customer_id);
    Appointment appointment = customer.getAppointment();
    List<UsedPart> usedParts = usedPartService.loadUsedPartsByAppointment(appointment);

    // Ensure that the Appointment Model exists within the Thymeleaf form
    if (appointment == null) {
      appointment = new Appointment();
    }

    model.addAttribute("customer", customer);
    model.addAttribute("appointment", appointment);
    model.addAttribute("usedParts", usedParts);
    return "customer/customer";
  }

  @RequestMapping(value="/customer/{customer_id}/remove", method = RequestMethod.DELETE)
  public String remove(Authentication authentication, @PathVariable int customer_id) throws IllegalAccessException, NotFoundException {
    customerService.remove(authentication, customer_id);
    return "redirect:/customers";
  }
}
