package com.main.easyFix.parts;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class PartController {
  private final PartService partService;

  @GetMapping("/parts")
  public String parts(Part part, Model model) {
    model.addAttribute("parts", partService.listAllParts());
    return "parts";
  }

  @PostMapping("/parts/add")
  public String add(Authentication authentication, Part part) throws IllegalAccessException {
    partService.add(authentication, part);
    return "parts";
  }
}
