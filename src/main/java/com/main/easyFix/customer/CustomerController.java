package com.main.easyFix.customer;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
