package com.jet.position.services;

import com.jet.position.dto.CustomerDto;
import com.jet.position.entity.Customer;
import com.jet.position.repository.CustomerRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @project position
 * @version 1.0
 * @author MENDJIJET
 * @since 16/07/2024
 */
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
  CustomerRepository customerRepository;

  @Override
  public List<CustomerDto> search() {
    return this.customerRepository.findAll().stream()
        .map(customer -> new CustomerDto(customer.getId(), customer.getEmail()))
        .toList();
  }

  @Override
  public CustomerDto read(int id) {
    Customer customer =
        customerRepository
            .findById(id)
            .orElseThrow(() -> new IllegalArgumentException("No customer for Id: "+id));
    return new CustomerDto(customer.getId(), customer.getEmail());
  }
}
