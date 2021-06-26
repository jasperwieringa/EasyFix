package com.main.easyFix.customer;

import com.main.easyFix.appointment.Appointment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;
  @NotEmpty(message = "The customer's name cannot be empty")
  private String firstName;
  @NotEmpty(message = "The customer's lastname cannot be empty")
  private String lastName;
  @NotEmpty(message = "The customer's address cannot be empty")
  private String address;
  @NotEmpty(message = "The customer's postal code cannot be empty")
  private String postalCode;
  @NotEmpty(message = "The customer's town cannot be empty")
  private String town;
  @NotEmpty(message = "The customer's email cannot be empty")
  private String email;
  @NotEmpty(message = "The customer's phone number cannot be empty")
  private String phone;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "appointment_id", referencedColumnName = "id")
  private Appointment appointment;
}
