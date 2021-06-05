package com.main.easyFix.customer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class CustomerController {
  private final CustomerService customerService;

  @GetMapping("/customers")
  public String customers(Customer customer, Model model) {
    model.addAttribute("customers", customerService.listAllCustomers());
    return "customer";
  }

  @PostMapping("/customers/add")
  public String register(@Valid Customer customer, BindingResult result, Model model) {
    String err = customerService.validateRegistration(customer);

    if (!err.isEmpty()) {
      ObjectError error = new ObjectError("globalError", err);
      result.addError(error);
    }

    if (result.hasErrors()) {
      return "customer";
    }

    customerService.register(customer);
    model.addAttribute("customers", customerService.listAllCustomers());
    return "customer";
  }
}
