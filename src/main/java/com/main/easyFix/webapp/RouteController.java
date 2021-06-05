package com.main.easyFix.webapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RouteController {
  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @GetMapping("/")
  public String index() {
    return "index";
  }

  @GetMapping("/customers")
  public String customers() {
    return "customer";
  }

  @GetMapping("/employees")
  public String employees() {
    return "employee";
  }
}
