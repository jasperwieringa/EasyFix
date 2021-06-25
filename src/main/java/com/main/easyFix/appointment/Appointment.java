package com.main.easyFix.appointment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "appointments")
public class Appointment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;
  @NotEmpty(message = "Please give a description of the computer")
  private String computer;
  @NotEmpty(message = "Please describe what is wrong with the computer")
  private String description;
  @Enumerated(EnumType.STRING)
  private AppointmentStatus status;
  @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
  @NotNull(message = "Please select a date")
  private Date date;
  private String issues;
  private String activities;
}

