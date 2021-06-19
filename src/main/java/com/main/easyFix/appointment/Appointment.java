package com.main.easyFix.appointment;

import com.main.easyFix.customer.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "appointment")
public class Appointment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;
  private String computer;
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
}

