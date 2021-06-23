package com.main.easyFix.parts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

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
  private Long id;
  @NotEmpty(message = "Please write down the name")
  private String name;
  @NotEmpty(message = "Please write down a description")
  private String description;
  @Enumerated(EnumType.STRING)
  private PartCategory category;
  @NotEmpty(message = "Please write down the price")
  private Float price;
  @NotEmpty(message = "Please write down the availability in stock")
  private Integer stock;
}
