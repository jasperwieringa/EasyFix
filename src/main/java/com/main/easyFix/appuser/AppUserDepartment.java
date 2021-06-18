package com.main.easyFix.appuser;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AppUserDepartment {
  ADMIN("Administration"),
  EXPERT("Expert"),
  CASHIER("Cashier"),
  BACKOFFICE("Backoffice");

  private final String displayValue;
}