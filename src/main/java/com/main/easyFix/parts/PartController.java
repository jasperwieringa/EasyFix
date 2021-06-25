package com.main.easyFix.parts;

import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class PartController {
  private final PartService partService;

  @GetMapping("/parts")
  public String parts(Part part, Model model) {
    model.addAttribute("parts", partService.listAllParts());
    return "parts/parts";
  }

  @PostMapping("/parts/add")
  public String add(Authentication authentication, Part part) throws IllegalAccessException {
    partService.save(authentication, part);
    return "redirect:/parts";
  }

  @GetMapping("/part/{id}")
  public String part(@PathVariable int id, Part part, Model model) throws NotFoundException {
    model.addAttribute("part", partService.loadPartById(id));
    return "parts/part";
  }

  @PostMapping("/part/{id}/update")
  public String update(Authentication authentication, Part part) throws IllegalAccessException {
    partService.update(authentication, part);
    return "redirect:/part/" + part.getId();
  }

  @RequestMapping(value="/part/{id}/remove", method = RequestMethod.DELETE)
  public String remove(Authentication authentication, Part part) throws IllegalAccessException {
    partService.remove(authentication, part);
    return "redirect:/parts";
  }
}
