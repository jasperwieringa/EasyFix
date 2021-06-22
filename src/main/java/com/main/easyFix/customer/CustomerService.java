package com.main.easyFix.customer;

import com.main.easyFix.appointment.Appointment;
import com.main.easyFix.appointment.AppointmentRequest;
import com.main.easyFix.appointment.AppointmentService;
import com.main.easyFix.appointment.AppointmentStatus;
import com.main.easyFix.utils.DateConverter;
import com.main.easyFix.utils.EmailValidator;
import com.main.easyFix.utils.PermissionValidator;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.text.ParseException;

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

  public void add(Authentication authentication, Customer customer) throws IllegalAccessException {
    if (!PermissionValidator.isAdmin(authentication)) {
      throw new IllegalAccessException("Permission denied");
    }

    if (!emailValidator.test(customer.getEmail())) {
      throw new IllegalStateException("Invalid email address");
    }

    boolean emailInUse = customerRepository.findByEmail(customer.getEmail()).isPresent();
    if (emailInUse) {
      throw new IllegalStateException("A customer with this email already exists");
    }

    customerRepository.save(customer);
  }

  public void remove(Authentication authentication, Long id) throws IllegalAccessException {
    if (!PermissionValidator.isAdmin(authentication)) {
      throw new IllegalAccessException("Permission denied");
    }

    customerRepository.delete(loadCustomerById(id));
  }

  public void addAppointment(Authentication authentication, AppointmentRequest request, Long id) throws IllegalAccessException, ParseException {
    if (!PermissionValidator.isAdmin(authentication)) {
      throw new IllegalAccessException("Permission denied");
    }

    // Create a new appointment with a default status and converted date
    Appointment appointment = appointmentService.add(new Appointment(
      request.getComputer(),
      request.getDescription(),
      AppointmentStatus.REPORTED,
      DateConverter.convert(request.getDate())
    ));

    Customer customer = loadCustomerById(id);
    customer.setAppointment(appointment);
    customerRepository.save(customer);
  }
}
