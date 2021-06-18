package com.main.easyFix.customer;

import com.main.easyFix.utils.EmailValidator;
import com.main.easyFix.utils.PermissionValidator;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {
  private final static String CLIENT_NOT_FOUND_MSG = "Customer with %s: %s, not found";
  private final CustomerRepository customerRepository;
  private final EmailValidator emailValidator;

  public Customer loadCustomerById(Long id) throws UsernameNotFoundException {
    return customerRepository.findById(id).orElseThrow(() ->
      new UsernameNotFoundException(String.format(CLIENT_NOT_FOUND_MSG, "id", id)));
  }

  public Object listAllCustomers() {
    return customerRepository.findAll();
  }

  public void register(Customer customer) {
    customerRepository.save(customer);
  }

  public void remove(Long id) {
    customerRepository.delete(loadCustomerById(id));
  }

  public String validateRegistration(Authentication authentication, Customer customer) {
    if (!PermissionValidator.isAdmin(authentication)) {
      return "Permission denied";
    }

    if (!emailValidator.test(customer.getEmail())) {
      return "Invalid email address";
    }

    boolean emailInUse = customerRepository.findByEmail(customer.getEmail()).isPresent();
    if (emailInUse) {
      return "A customer with this email already exists";
    }
    return "";
  }

  public String validateRemoval(Authentication authentication) {
    if (!PermissionValidator.isAdmin(authentication)) {
      return "Permission denied";
    }
    return "";
  }
}
