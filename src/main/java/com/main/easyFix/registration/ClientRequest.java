package com.main.easyFix.registration;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ClientRequest {
  private final String firstName;
  private final String lastName;
  private final String address;
  private final String postalCode;
  private final String email;
  private final String phone;
  private final String computer;
}
