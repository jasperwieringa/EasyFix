package com.main.easyFix.registration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/client")
@AllArgsConstructor
public class ClientController {
  private final ClientService clientService;

  @PostMapping
  public String register(@RequestBody ClientRequest request) {
    return clientService.register(request);
  }
}
