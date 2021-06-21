package com.main.easyFix.customer;

import com.main.easyFix.appointment.Appointment;
import com.main.easyFix.appointment.AppointmentService;
import com.main.easyFix.appointment.AppointmentStatus;
import com.main.easyFix.utils.EmailValidator;
import com.main.easyFix.utils.PermissionValidator;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {
  private final static String CLIENT_NOT_FOUND_MSG = "Customer with %s: %s, not found";
  private final CustomerRepository customerRepository;
  private final AppointmentService appointmentService;
  private final EmailValidator emailValidator;

  public Customer loadCustomerById(Long id) throws UsernameNotFoundException {
    return customerRepository.findById(id).orElseThrow(() ->
      new UsernameNotFoundException(String.format(CLIENT_NOT_FOUND_MSG, "id", id)));
  }

  public Object listAllCustomers() {
    return customerRepository.findAll();
  }

  public String register(Authentication authentication, Customer customer) {
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

    customerRepository.save(customer);
    return "OK";
  }

  public String remove(Authentication authentication, Long id) {
    if (!PermissionValidator.isAdmin(authentication)) {
      return "Permission denied";
    }

    customerRepository.delete(loadCustomerById(id));
    return "OK";
  }

  public String addAppointment(Authentication authentication, Appointment appointment, Long id) {
    if (!PermissionValidator.isAdmin(authentication)) {
      return "Permission denied";
    }

    Appointment appointmentWithStatus = appointmentService.add(new Appointment(
      appointment.getComputer(),
      appointment.getDescription(),
      AppointmentStatus.REPORTED
    ));

    Customer customer = loadCustomerById(id);
    customer.setAppointment(appointmentWithStatus);
    return "OK";
  }
}
