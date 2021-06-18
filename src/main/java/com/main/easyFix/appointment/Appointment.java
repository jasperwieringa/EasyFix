package com.main.easyFix.appointment;

import com.main.easyFix.customer.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
  @OneToOne(mappedBy = "appointment")
  private Customer customer;
  private String computer;
  private String description;
  private String issues;
  private String status;
//  @OneToMany(mappedBy="order")
//  private Set<Activity> activities;
//  @OneToMany(mappedBy="order")
//  private Set<Part> usedParts;
//  @OneToOne(cascade = CascadeType.ALL)
//  @JoinColumn(name = "appointment_id", referencedColumnName = "id")
//  private Appointment appointment;
//  @OneToOne(cascade = CascadeType.ALL)
//  @JoinColumn(name = "receipt_id", referencedColumnName = "id")
//  private Receipt receipt;
}

