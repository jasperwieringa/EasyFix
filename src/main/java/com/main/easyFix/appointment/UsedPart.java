package com.main.easyFix.appointment;

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
@Table(name = "used_parts")
public class UsedPart {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "appointment_id", nullable = false,
    foreignKey = @ForeignKey(name = "used_parts_apt_fk"))
  private Appointment appointment;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "part_id", nullable = false,
    foreignKey = @ForeignKey(name = "used_parts_part_fk"))
  private Part part;

  private int quantity;
}
