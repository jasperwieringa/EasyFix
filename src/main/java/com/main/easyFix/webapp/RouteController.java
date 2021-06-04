package com.main.easyFix.webapp;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RouteController {
  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @GetMapping("/")
  public String index(Model model) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String currentPrincipalName = authentication.getName();
    model.addAttribute("username", currentPrincipalName);
    return "index";
  }
}
