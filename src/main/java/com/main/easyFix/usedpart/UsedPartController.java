package com.main.easyFix.usedpart;

import com.main.easyFix.appointment.Appointment;
import com.main.easyFix.customer.Customer;
import com.main.easyFix.customer.CustomerService;
import com.main.easyFix.parts.Part;
import com.main.easyFix.parts.PartService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@RestController
public class UsedPartController {
  private final CustomerService customerService;
  private final PartService partService;
  private final UsedPartService usedPartService;

  @PostMapping("/customer/{customer_id}/appointment/add_part")
  public ResponseEntity<?> add(Authentication authentication, @Valid @RequestBody List<UsedPartRequest> request, @PathVariable int customer_id, Errors errors) throws IllegalAccessException, NotFoundException {
    UsedPartResponseBody result = new UsedPartResponseBody();

    Customer customer = customerService.loadCustomerById(customer_id);
    Appointment appointment = customer.getAppointment();

    for (UsedPartRequest usedPartRequest : request) {
      Part part = partService.loadPartById(usedPartRequest.getPart());
      int quantity = usedPartRequest.getQuantity();

      UsedPart usedPart = new UsedPart();
      usedPart.setAppointment(appointment);
      usedPart.setPart(part);
      usedPart.setQuantity(quantity);

      usedPartService.add(authentication, usedPart);
    }

    if (errors.hasErrors()) {
      result.setMsg(errors.getAllErrors()
      .stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
      .collect(Collectors.joining(",")));
    } else {
      result.setMsg("Success");
      List<UsedPart> usedParts = usedPartService.loadUsedPartsByAppointment(appointment);
      result.setUsedParts(usedParts);
    }
    return ResponseEntity.ok(result);
  }
}
