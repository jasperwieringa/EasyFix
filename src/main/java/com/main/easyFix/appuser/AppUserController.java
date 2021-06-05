package com.main.easyFix.appuser;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/employee")
@AllArgsConstructor
public class AppUserController {
  private final AppUserService appUserService;

  @PostMapping
  public String register(@RequestBody AppUserRequest request) {
    return appUserService.register(request);
  }
}
