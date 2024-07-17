package com.jet.position.controller;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.jet.position.dto.CustomerDto;
import com.jet.position.services.CustomerServiceImpl;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @project position
 * @version 1.0
 * @author MENDJIJET
 * @since 16/07/2024
 */
@WebMvcTest(CustomerController.class)
class CustomerControllerTest {
  @Autowired MockMvc mockMvc;

  @MockBean CustomerServiceImpl customerService;

  @Test
  void shouldReturnListOfCustomers() throws Exception {
    // Arrange /Given
    CustomerDto customer = new CustomerDto(1, "mendjijet@gmail.com");
    CustomerDto customer1 = new CustomerDto(2, "mendjijet2@gmail.com");
    when(customerService.search()).thenReturn(List.of(customer, customer1));

    // Act Assert
    this.mockMvc
        .perform(get("/customers"))
        .andExpect(status().isOk())
        .andDo(print())
        .andExpect(content().string(containsString("mendjijet2@gmail.com")));
  }

  @Test
  void shouldReturnOneCustomer() throws Exception {
    // Arrange /Given
    CustomerDto customer = new CustomerDto(1, "mendjijet@gmail.com");
    when(customerService.read(anyInt())).thenReturn(customer);

    // Act Assert
    this.mockMvc
        .perform(get("/customers/1"))
        .andExpect(jsonPath("$.email").value(customer.email()))
        .andExpect(status().isOk())
        .andDo(print());
  }
}
