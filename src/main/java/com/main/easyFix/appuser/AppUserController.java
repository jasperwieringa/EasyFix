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
    return "appuser/employees";
  }

  @PostMapping("/employees/add")
  public String register(Authentication authentication, @Valid AppUser appUser) throws IllegalAccessException {
    appUserService.register(authentication, appUser);
    return "redirect:/employees";
  }

  @RequestMapping(value="/employees/{id}/remove", method = RequestMethod.DELETE)
  public String remove(Authentication authentication, @PathVariable Long id) throws IllegalAccessException {
    appUserService.remove(authentication, id);
    return "redirect:/employees";
  }
}
