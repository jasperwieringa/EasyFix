package com.main.easyFix.appointment;

import com.main.easyFix.customer.Customer;
import com.main.easyFix.customer.CustomerService;
import com.main.easyFix.security.PermissionValidator;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppointmentService {
  private final AppointmentRepository appointmentRepository;
  private final CustomerService customerService;

  public void add(Authentication authentication, Appointment appointment, int id) throws IllegalAccessException {
    if (!PermissionValidator.isAdmin(authentication)) {
      throw new IllegalAccessException("Permission denied");
    }

    // Overwrite the status
    appointment.setStatus(AppointmentStatus.REPORTED);
    appointmentRepository.save(appointment);

    // Update the customer
    Customer customer = customerService.loadCustomerById(id);
    customer.setAppointment(appointment);
    customerService.update(customer);
  }

  public void update(Authentication authentication, Appointment appointment) throws IllegalAccessException {
    if (!PermissionValidator.isAdmin(authentication) && !PermissionValidator.isExpert(authentication)) {
      throw new IllegalAccessException("Permission denied");
    }
    appointmentRepository.save(appointment);
  }

  public void remove(Authentication authentication, int id) throws IllegalAccessException {
    if (!PermissionValidator.isAdmin(authentication) && !PermissionValidator.isExpert(authentication)) {
      throw new IllegalAccessException("Permission denied");
    }

    Customer customer = customerService.loadCustomerById(id);
    Appointment appointment = customer.getAppointment();

    customer.setAppointment(null);
    customerService.update(customer);
    appointmentRepository.delete(appointment);
  }
}
