package com.main.easyFix.parts;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PartCategory {
  CABLE("Cables"),
  CASE("Cases"),
  MOTHERBOARD("Motherboards"),
  PROCESSOR("Processors"),
  GRAPHICS_CARD("Graphics cards"),
  RAM("RAM"),
  COOLING("Cooling"),
  POWER_SUPPLY("Power supplies"),
  OPERATING_SYSTEM("Operating systems"),
  NETWORK("Network");

  private final String displayValue;
}
