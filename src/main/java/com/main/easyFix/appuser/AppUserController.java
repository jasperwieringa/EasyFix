package com.main.easyFix.appuser;

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
public class AppUserController {
  private final AppUserService appUserService;

  @GetMapping("/employees")
  public String customers(AppUser appUser, Model model) {
    model.addAttribute("employees", appUserService.listAllEmployees());
    return "employee";
  }

  @PostMapping("/employees/add")
  public String register(@Valid AppUser appUser, BindingResult result, Model model) {
    String err = appUserService.validateRegistration(appUser);

    if (!err.isEmpty()) {
      ObjectError error = new ObjectError("globalError", err);
      result.addError(error);
    }

    if (result.hasErrors()) {
      return "employee";
    }

    appUserService.register(appUser);
    model.addAttribute("employees", appUserService.listAllEmployees());
    return "employee";
  }
}
