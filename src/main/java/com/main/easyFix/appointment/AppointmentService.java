package com.main.easyFix.appointment;

import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppointmentService {
  private final static String ORDER_NOT_FOUND_MSG = "Order with id %s not found";
  private final AppointmentRepository appointmentRepository;

  public Appointment loadOrderById(Long id) throws NotFoundException {
    return appointmentRepository.findById(id).orElseThrow(() ->
      new NotFoundException(String.format(ORDER_NOT_FOUND_MSG, id)));
  }

  public Appointment loadOrderByCustomerId(Long id) throws NotFoundException {
    return appointmentRepository.findByCustomerId(id).orElseThrow(() ->
      new NotFoundException(String.format(ORDER_NOT_FOUND_MSG, id)));
  }

  public Object listAllOrders() {
    return appointmentRepository.findAll();
  }
}
