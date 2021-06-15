package com.main.easyFix.utils;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class permissionValidator {
  public boolean test(Authentication authentication) {
    return authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ADMIN"));
  }
}
