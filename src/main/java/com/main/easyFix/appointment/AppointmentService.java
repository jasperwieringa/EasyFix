package com.main.easyFix.appointment;

import com.main.easyFix.customer.Customer;
import com.main.easyFix.customer.CustomerService;
import com.main.easyFix.security.PermissionValidator;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppointmentService {
  private final AppointmentRepository appointmentRepository;
  private final CustomerService customerService;

  public void add(Authentication authentication, Appointment appointment, int customer_id) throws IllegalAccessException {
    if (!PermissionValidator.isAdmin(authentication)) {
      throw new IllegalAccessException("Permission denied");
    }

    // Overwrite the status
    appointment.setStatus(AppointmentStatus.REPORTED);
    appointmentRepository.save(appointment);

    // Update the customer
    Customer customer = customerService.loadCustomerById(customer_id);
    customer.setAppointment(appointment);
    customerService.update(customer);
  }

  public void update(Authentication authentication, Appointment appointment, int customer_id) throws IllegalAccessException {
    if (!PermissionValidator.isAdmin(authentication) && !PermissionValidator.isExpert(authentication)) {
      throw new IllegalAccessException("Permission denied");
    }

    // Update the customer
    Customer customer = customerService.loadCustomerById(customer_id);
    customer.setAppointment(appointment);
    customerService.update(customer);
  }

  public void remove(Authentication authentication, int customer_id) throws IllegalAccessException, NotFoundException {
    if (!PermissionValidator.isAdmin(authentication) && !PermissionValidator.isExpert(authentication)) {
      throw new IllegalAccessException("Permission denied");
    }

    // Update the customer
    Customer customer = customerService.loadCustomerById(customer_id);
    Appointment appointment = customer.getAppointment();
    customer.setAppointment(null);
    customerService.update(customer);
    
    // Remove the appointment
    appointmentRepository.delete(appointment);
  }
}
