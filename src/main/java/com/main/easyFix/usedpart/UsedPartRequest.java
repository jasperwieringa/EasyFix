package com.main.easyFix.usedpart;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class UsedPartRequest {
  private final int part;
  private final int quantity;
}