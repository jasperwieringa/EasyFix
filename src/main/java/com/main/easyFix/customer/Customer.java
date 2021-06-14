package com.main.easyFix.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotEmpty(message = "The customer's name cannot be empty")
  private String firstName;
  @NotEmpty(message = "The customer's lastname cannot be empty")
  private String lastName;
  private String address;
  private String postalCode;
  @NotEmpty(message = "The customer's email cannot be empty")
  private String email;
  @NotEmpty(message = "The customer's phone number cannot be empty")
  private String phone;
  private Integer appointments;

  public Customer(String firstName, String lastName, String address, String postalCode, String email, String phone) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.postalCode = postalCode;
    this.email = email;
    this.phone = phone;
  }
}
