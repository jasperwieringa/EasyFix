package com.main.easyFix.security;

import com.main.easyFix.appuser.AppUserDepartment;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class PermissionValidator {
  public static boolean isAdmin(Authentication authentication) {
    return authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals(AppUserDepartment.ADMIN.toString()));
  }

  public static boolean isExpert(Authentication authentication) {
    return authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals(AppUserDepartment.EXPERT.toString()));
  }

  public static boolean isCashier(Authentication authentication) {
    return authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals(AppUserDepartment.CASHIER.toString()));
  }

  public static boolean isBackoffice(Authentication authentication) {
    return authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals(AppUserDepartment.BACKOFFICE.toString()));
  }
}
