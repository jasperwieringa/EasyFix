package com.main.easyFix.registration;

import com.main.easyFix.customer.Customer;
import com.main.easyFix.customer.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientService {
  private final CustomerService customerService;
  private final EmailValidator emailValidator;

  public String register(ClientRequest request) {
    String firstName = request.getFirstName();
    String lastName = request.getLastName();
    String address = request.getAddress();
    String postalCode = request.getPostalCode();
    String email = request.getEmail();
    String phone = request.getPhone();
    String computer = request.getComputer();
    boolean isValidEmail = emailValidator.test(email);

    if (!isValidEmail) {
      throw new IllegalStateException("Onjuist e-mailadres");
    }

    return customerService.signUpCustomer(
      new Customer(firstName, lastName, address, postalCode, email, phone, computer)
    );
  }
}
