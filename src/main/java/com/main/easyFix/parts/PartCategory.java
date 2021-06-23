package com.main.easyFix.parts;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PartCategory {
  CABLE("Cable"),
  CASE("Case"),
  MOTHERBOARD("Motherboard"),
  PROCESSOR("Processor"),
  GRAPHICS_CARD("Graphics card"),
  RAM("RAM"),
  COOLING("Cooling"),
  POWER_SUPPLY("Power supply"),
  OPERATING_SYSTEM("Operating system"),
  NETWORK("Network");

  private final String displayValue;
}
