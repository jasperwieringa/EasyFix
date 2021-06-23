package com.main.easyFix.parts;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class PartController {
  private final PartService partService;

  @GetMapping("/parts")
  public String parts(Part part, Model model) {
    model.addAttribute("parts", partService.listAllParts());
    return "parts";
  }
}
