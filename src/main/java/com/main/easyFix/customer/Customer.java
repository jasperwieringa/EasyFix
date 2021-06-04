package com.main.easyFix.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String firstName;
  private String lastName;
  private String address;
  private String postalCode;
  private String email;
  private String phone;
  private String computer;

  public Customer(String firstName, String lastName, String address, String postalCode, String email, String phone, String computer) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.postalCode = postalCode;
    this.email = email;
    this.phone = phone;
    this.computer = computer;
  }
}
