package com.main.easyFix.parts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Parts")
public class Part {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;
  @NotEmpty(message = "Please fill in the name")
  private String name;
  @Enumerated(EnumType.STRING)
  private PartCategory category;
  @NotNull(message = "Please fill in the price")
  private Float price;
  @NotNull(message = "Please fill in the availability in stock")
  private Integer stock;
}
