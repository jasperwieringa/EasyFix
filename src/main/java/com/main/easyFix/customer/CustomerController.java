package com.main.easyFix.customer;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/customer")
@AllArgsConstructor
public class CustomerController {
  private final CustomerService customerService;

  @PostMapping
  public String register(@RequestBody CustomerRequest request) {
    return customerService.register(request);
  }
}
