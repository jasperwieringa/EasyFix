package com.main.easyFix.registration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/employee")
@AllArgsConstructor
public class EmployeeController {
  private final EmployeeService employeeService;

  @GetMapping
  public String register() {
    return "employee_registration";
  }

  @PostMapping
  public String register(@RequestBody EmployeeRequest request) {
    return employeeService.register(request);
  }
}
