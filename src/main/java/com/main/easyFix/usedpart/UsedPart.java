package com.main.easyFix.usedpart;

import com.main.easyFix.appointment.Appointment;
import com.main.easyFix.appointment.AppointmentService;
import com.main.easyFix.parts.Part;
import com.main.easyFix.parts.PartService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "used_parts")
public class UsedPart {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @ManyToOne
  @JoinColumn(name = "appointment_id")
  private Appointment appointment;

  @ManyToOne
  @JoinColumn(name = "part_id")
  private Part part;

  private int quantity;
}
