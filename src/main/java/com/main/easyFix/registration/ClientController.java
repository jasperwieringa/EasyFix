package com.main.easyFix.registration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/customer")
@AllArgsConstructor
public class ClientController {
  private final ClientService clientService;

  @GetMapping
  public String getTemplate() {
    return "client_registration";
  }

  @PostMapping
  public String register(@RequestBody ClientRequest request) {
    return clientService.register(request);
  }
}
