package com.main.easyFix.order;

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
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne
  @JoinColumn(name="customer_id", referencedColumnName = "id", nullable=false)
  private Customer customer;
  private String computer;
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
  private String description;
  private String issues;
  private String status;
}

