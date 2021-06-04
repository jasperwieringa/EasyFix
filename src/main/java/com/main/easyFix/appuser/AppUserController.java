package com.main.easyFix.appuser;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/user")
@AllArgsConstructor
public class AppUserController {
  private final AppUserService appUserService;

  @PostMapping
  public String register(@RequestBody AppUserRequest request) {
    return appUserService.register(request);
  }
}
