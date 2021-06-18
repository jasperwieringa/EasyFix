package com.main.easyFix.order;

import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderService {
  private final static String ORDER_NOT_FOUND_MSG = "Order with id %s not found";
  private final OrderRepository orderRepository;

  public Order loadOrderById(Long id) throws NotFoundException {
    return orderRepository.findById(id).orElseThrow(() ->
      new NotFoundException(String.format(ORDER_NOT_FOUND_MSG, id)));
  }

  public Order loadOrderByCustomerId(Long id) throws NotFoundException {
    return orderRepository.findByCustomerId(id).orElseThrow(() ->
      new NotFoundException(String.format(ORDER_NOT_FOUND_MSG, id)));
  }

  public Object listAllOrders() {
    return orderRepository.findAll();
  }
}
