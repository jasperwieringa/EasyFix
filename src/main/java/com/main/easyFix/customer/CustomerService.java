package com.main.easyFix.customer;

import com.main.easyFix.utils.EmailValidator;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {
  private final static String CLIENT_NOT_FOUND_MSG = "Customer with %s: %s, not found";
  private final static String CLIENT_EXISTS_MSG = "A customer with these credentials already exists";
  private final CustomerRepository customerRepository;
  private final EmailValidator emailValidator;

  public Customer loadUserByLastName(String lastName) throws UsernameNotFoundException {
    return customerRepository.findByLastName(lastName).orElseThrow(() ->
      new UsernameNotFoundException(String.format(CLIENT_NOT_FOUND_MSG, "lastname", lastName)));
  }

  public Customer loadUserByPostalCode(String postalCode) throws UsernameNotFoundException {
    return customerRepository.findByPostalCode(postalCode).orElseThrow(() ->
      new UsernameNotFoundException(String.format(CLIENT_NOT_FOUND_MSG, "postal code", postalCode)));
  }

  public Customer loadUserByEmail(String email) throws UsernameNotFoundException {
    return customerRepository.findByEmail(email).orElseThrow(() ->
      new UsernameNotFoundException(String.format(CLIENT_NOT_FOUND_MSG, "email", email)));
  }

  public Object listAllCustomers() {
    return customerRepository.findAll();
  }

  public Customer register(CustomerRequest request) {
    String firstName = request.getFirstName();
    String lastName = request.getLastName();
    String address = request.getAddress();
    String postalCode = request.getPostalCode();
    String email = request.getEmail();
    String phone = request.getPhone();
    boolean isValidEmail = emailValidator.test(email);

    if (!isValidEmail) {
      throw new IllegalStateException("Incorrect e-mail");
    }

    return signUpCustomer(
      new Customer(firstName, lastName, address, postalCode, email, phone)
    );
  }

  public Customer signUpCustomer(Customer customer) {
    boolean lastNameInUse = customerRepository.findByLastName(customer.getLastName()).isPresent();
    boolean postalCodeInUse = customerRepository.findByPostalCode(customer.getPostalCode()).isPresent();
    boolean emailInUse = customerRepository.findByEmail(customer.getEmail()).isPresent();

    if (lastNameInUse || postalCodeInUse || emailInUse) {
      throw new IllegalStateException(CLIENT_EXISTS_MSG);
    }

    customerRepository.save(customer);
    return customer;
  }
}
