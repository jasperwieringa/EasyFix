package com.main.easyFix.appointment;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AppointmentStatus {
  REPORTED("Reported"),
  REPAIRING("Repairing"),
  COMPLETE("Complete"),
  PAID("Paid"),
  CANCELED("Canceled");

  private final String displayValue;
}
