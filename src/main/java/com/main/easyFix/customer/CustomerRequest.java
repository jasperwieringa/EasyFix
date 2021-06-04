package com.main.easyFix.customer;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class CustomerRequest {
  private final String firstName;
  private final String lastName;
  private final String address;
  private final String postalCode;
  private final String email;
  private final String phone;
}