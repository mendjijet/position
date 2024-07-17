package com.jet.position.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import com.jet.position.dto.CustomerDto;
import com.jet.position.entity.Customer;
import com.jet.position.repository.CustomerRepository;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * @project position
 * @version 1.0
 * @author MENDJIJET
 * @since 16/07/2024
 */
@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

  @Mock CustomerRepository customerRepository;

  @InjectMocks CustomerServiceImpl customerService;

  @Test
  void shouldReturnListOfCustomers() {
    // Arrange /Given
    Customer customer = Customer.builder().id(1).email("mendjijet@gmail.com").build();
    Customer customer1 = Customer.builder().id(2).email("mendjijet2@gmail.com").build();
    when(customerRepository.findAll()).thenReturn(List.of(customer, customer1));

    // Act /When
    List<CustomerDto> customerDtos = this.customerService.search();

    // Assert /Then
    assertEquals(2, customerDtos.size());
  }

  @Test
  void shouldReturnCustomerById() {
    // Arrange /Given
    Customer customer = Customer.builder().id(1).email("mendjijet@gmail.com").build();
    when(customerRepository.findById(1)).thenReturn(Optional.of(customer));

    // Act /When
    CustomerDto customerDto = this.customerService.read(1);

    // Assert /Then
    assertEquals(customerDto.id(), customer.getId());
    assertEquals(customerDto.email(), customer.getEmail());
  }

  @Test
  void shouldReturnIllegalException() {
    // Arrange /Given
    when(customerRepository.findById(anyInt())).thenReturn(Optional.empty());

    // Act /When

    // Assert /Then
    IllegalArgumentException illegalArgumentException =
        assertThrows(IllegalArgumentException.class, () -> this.customerService.read(1));
    assertEquals("No customer for Id: 1", illegalArgumentException.getMessage());
  }
}
