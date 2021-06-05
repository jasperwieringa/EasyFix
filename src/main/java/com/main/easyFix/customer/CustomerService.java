package com.main.easyFix.customer;

import com.main.easyFix.utils.EmailValidator;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {
  private final static String CLIENT_NOT_FOUND_MSG = "Customer with %s: %s, not found";
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

  public Customer register(Customer customer) {
    String firstName = customer.getFirstName();
    String lastName = customer.getLastName();
    String address = customer.getAddress();
    String postalCode = customer.getPostalCode();
    String email = customer.getEmail();
    String phone = customer.getPhone();

    Customer newCustomer = new Customer(firstName, lastName, address, postalCode, email, phone);
    customerRepository.save(customer);

    return newCustomer;
  }

  public String validateRegistration(Customer customer) {
    String message = "";

    boolean isValidEmail = emailValidator.test(customer.getEmail());
    boolean lastNameInUse = customerRepository.findByLastName(customer.getLastName()).isPresent();
    boolean postalCodeInUse = customerRepository.findByPostalCode(customer.getPostalCode()).isPresent();
    boolean emailInUse = customerRepository.findByEmail(customer.getEmail()).isPresent();

    if (!isValidEmail) {
      message = "Invalid email address";
    }

    if (lastNameInUse || postalCodeInUse || emailInUse) {
      message = "A customer with these credentials already exists";
    }

    return message;
  }
}
