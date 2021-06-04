package com.main.easyFix.customer;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {
  private final static String CLIENT_NOT_FOUND_MSG = "Klant met %s: %s, niet gevonden";
  private final CustomerRepository customerRepository;

  public Customer loadUserByLastName(String lastName) throws UsernameNotFoundException {
    return customerRepository.findByLastName(lastName).orElseThrow(() ->
      new UsernameNotFoundException(String.format(CLIENT_NOT_FOUND_MSG, "achternaam", lastName)));
  }

  public Customer loadUserByAddress(String address) throws UsernameNotFoundException {
    return customerRepository.findByAddress(address).orElseThrow(() ->
      new UsernameNotFoundException(String.format(CLIENT_NOT_FOUND_MSG, "adres", address)));
  }

  public Customer loadUserByEmail(String email) throws UsernameNotFoundException {
    return customerRepository.findByEmail(email).orElseThrow(() ->
      new UsernameNotFoundException(String.format(CLIENT_NOT_FOUND_MSG, "email", email)));
  }

  public String signUpCustomer(Customer customer) {
    boolean customerExists = customerRepository.findByEmail(customer.getEmail()).isPresent();

    if (customerExists) {
      throw new IllegalStateException("Een klant met dit e-mailadres staat al in het systeem");
    }

    customerRepository.save(customer);
    return "Success";
  }
}
