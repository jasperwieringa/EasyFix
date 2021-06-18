package com.main.easyFix.customer;

import com.main.easyFix.order.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

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
  @NotEmpty(message = "The customer's address cannot be empty")
  private String address;
  private String postalCode;
  @NotEmpty(message = "The customer's town cannot be empty")
  private String town;
  @NotEmpty(message = "The customer's email cannot be empty")
  private String email;
  @NotEmpty(message = "The customer's phone number cannot be empty")
  private String phone;
  @OneToMany(mappedBy="customer")
  private Set<Order> orders;

  public Customer(String firstName, String lastName, String address, String postalCode, String town, String email, String phone) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.postalCode = postalCode;
    this.town = town;
    this.email = email;
    this.phone = phone;
  }
}
