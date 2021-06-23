package com.main.easyFix.details;

import com.main.easyFix.appointment.Appointment;
import com.main.easyFix.parts.Part;
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
@Table(name = "Details")
public class Detail {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "appointment_id")
  private Appointment appointment;

  @ManyToOne
  @JoinColumn(name = "part_id")
  private Part part;

  private Integer quantity;
  private Float price;
  private Double amount;
}
