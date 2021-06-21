package com.main.easyFix.appuser;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class AppUserController {
  private final AppUserService appUserService;

  @GetMapping("/employees")
  public String customers(AppUser appUser, Model model) {
    model.addAttribute("employees", appUserService.listAllEmployees());
    return "employees";
  }

  @PostMapping("/employees/add")
  public String register(Authentication authentication, @Valid AppUser appUser, Model model) throws IllegalAccessException {
    appUserService.register(authentication, appUser);
    model.addAttribute("employees", appUserService.listAllEmployees());
    return "employees";
  }

  @RequestMapping(value="/employees/remove/{id}", method = RequestMethod.DELETE)
  public String remove(Authentication authentication, AppUser appUser, @PathVariable Long id, Model model) throws IllegalAccessException {
    appUserService.remove(authentication, id);
    model.addAttribute("employees", appUserService.listAllEmployees());
    return "employees";
  }
}
