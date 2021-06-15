package com.main.easyFix.appuser;

import com.main.easyFix.customer.Customer;
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
public class AppUserController {
  private final AppUserService appUserService;

  @GetMapping("/employees")
  public String customers(AppUser appUser, Model model) {
    model.addAttribute("employees", appUserService.listAllEmployees());
    return "employee";
  }

  @PostMapping("/employees/add")
  public String register(Authentication authentication, @Valid AppUser appUser, BindingResult result, Model model) {
    String err = appUserService.validateRegistration(authentication, appUser);

    if (!err.isEmpty()) {
      ObjectError error = new ObjectError("globalError", err);
      result.addError(error);
    }

    if (!result.hasErrors()) {
      model.addAttribute("success_message", "Successfully added a new employee");
    }

    appUserService.register(appUser);
    model.addAttribute("employees", appUserService.listAllEmployees());
    return "employee";
  }

  @RequestMapping(value="/employees/remove/{id}", method = RequestMethod.DELETE)
  public String remove(Authentication authentication, AppUser appUser, @PathVariable Long id, BindingResult result, Model model) {
    String err = appUserService.validateRemoval(authentication);

    if (!err.isEmpty()) {
      ObjectError error = new ObjectError("globalError", err);
      result.addError(error);
    }

    if (!result.hasErrors()) {
      model.addAttribute("success_message", "Employee successfully removed");
    }

    appUserService.remove(id);
    model.addAttribute("employees", appUserService.listAllEmployees());
    return "employee";
  }
}
