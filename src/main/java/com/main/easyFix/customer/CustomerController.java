package com.main.easyFix.customer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@AllArgsConstructor
public class CustomerController {
  private final CustomerService customerService;

  @GetMapping("/customers")
  public String customers(Customer customer, Model model) {
    model.addAttribute("customers", customerService.listAllCustomers());
    return "customer";
  }

  @PostMapping("/customer/add")
  public RedirectView register(Customer customer, CustomerRequest request) {
    customerService.register(request);
    return new RedirectView("/customers");
  }
}
