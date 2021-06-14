package com.main.easyFix.customer;

import com.main.easyFix.utils.EmailValidator;
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

  public String registerCustomer(Authentication authentication, Customer customer) {
    boolean isAdmin = authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));
    if (!isAdmin) {
      return "Permission denied";
    }

    boolean isValidEmail = emailValidator.test(customer.getEmail());
    if (!isValidEmail) {
      return "Invalid email address";
    }

    boolean emailInUse = customerRepository.findByEmail(customer.getEmail()).isPresent();
    if (emailInUse) {
      return "A customer with this email already exists";
    }

    customerRepository.save(customer);
    return "";
  }

  public String removeCustomer(Authentication authentication, Long id) {
    boolean isAdmin = authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));
    if (!isAdmin) {
      return "Permission denied";
    }

    customerRepository.delete(loadCustomerById(id));
    return "";
  }
}
