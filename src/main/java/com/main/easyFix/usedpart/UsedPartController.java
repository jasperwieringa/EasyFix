package com.main.easyFix.usedpart;

import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@AllArgsConstructor
public class UsedPartController {
  private final UsedPartService usedPartService;

  @PostMapping("/customer/{customer_id}/appointment/add_part")
  public String add(Authentication authentication, @PathVariable int customer_id) throws IllegalAccessException {
    usedPartService.add(authentication, customer_id);
    return "redirect:/customer/" + customer_id;
  }

  @RequestMapping(value="/customer/{customer_id}/appointment/remove_part", method = RequestMethod.DELETE)
  public String remove(Authentication authentication, @PathVariable int customer_id) throws IllegalAccessException, NotFoundException {
    usedPartService.remove(authentication, customer_id);
    return "redirect:/customer/" + customer_id;
  }
}
