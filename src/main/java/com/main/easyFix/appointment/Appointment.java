package com.main.easyFix.appointment;

import com.main.easyFix.customer.Customer;
import com.main.easyFix.receipt.Receipt;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Appointment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;
  @NotEmpty(message = "Please write down the type of computer")
  private String computer;
  @NotEmpty(message = "Please give a customer's description")
  private String description;
  @Enumerated(EnumType.STRING)
  private AppointmentStatus status;
  private Date date;
  private String issues;
  private String activities;

  @OneToOne(mappedBy = "appointment")
  private Customer customer;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "receipt_id", referencedColumnName = "id")
  private Receipt receipt;

  public Appointment(String computer, String description, AppointmentStatus status) {
    this.computer = computer;
    this.description = description;
    this.status = status;
  }
}

