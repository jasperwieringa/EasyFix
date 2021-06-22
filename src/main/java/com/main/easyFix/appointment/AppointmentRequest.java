package com.main.easyFix.appointment;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class AppointmentRequest {
  private final String computer;
  private final String description;
  private final String date;
}
