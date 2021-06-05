package com.main.easyFix.webapp;

import com.main.easyFix.customer.Customer;
import com.main.easyFix.customer.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class RouteController {
  private final CustomerService customerService;

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @GetMapping("/")
  public String index() {
    return "index";
  }

  @GetMapping("/employees")
  public String employees(Model model) {
    return "employee";
  }
}
