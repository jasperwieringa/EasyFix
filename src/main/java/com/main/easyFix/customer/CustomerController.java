package com.main.easyFix.customer;

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

  @GetMapping("/customers")
  public String customers(Customer customer, Model model) {
    Object customers = customerService.listAllCustomers();
    model.addAttribute("customers", customerService.listAllCustomers());
    return "customers";
  }

  @GetMapping("/customers/{id}")
  public String customers(@PathVariable Long id, Model model) {
    model.addAttribute("customer", customerService.loadCustomerById(id));
    return "customer";
  }

  @PostMapping("/customers/add")
  public String register(Authentication authentication, @Valid Customer customer, BindingResult result, Model model) {
    String err = customerService.validateRegistration(authentication, customer);

    if (!err.isEmpty()) {
      ObjectError error = new ObjectError("globalError", err);
      result.addError(error);
    }

    if (!result.hasErrors()) {
      customerService.register(customer);
      model.addAttribute("success_message", "Successfully added a new customer");
    }

    model.addAttribute("customers", customerService.listAllCustomers());
    return "customers";
  }

  @RequestMapping(value="/customers/remove/{id}", method = RequestMethod.DELETE)
  public String remove(Authentication authentication, Customer customer, @PathVariable Long id, BindingResult result, Model model) {
    String err = customerService.validateRemoval(authentication);

    if (!err.isEmpty()) {
      ObjectError error = new ObjectError("globalError", err);
      result.addError(error);
    }

    if (!result.hasErrors()) {
      model.addAttribute("success_message", "Customer successfully removed");
    }

    customerService.remove(id);
    model.addAttribute("customers", customerService.listAllCustomers());
    return "customers";
  }
}
