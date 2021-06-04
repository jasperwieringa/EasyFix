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
    String userName = authentication.getName();
    boolean isAdmin = authentication.getAuthorities().stream()
      .anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));

    model.addAttribute("username", userName);
    model.addAttribute("is_admin", isAdmin);
    return "index";
  }
}
