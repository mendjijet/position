package com.jet.position.dao;

import static org.junit.jupiter.api.Assertions.*;

import com.jet.position.dao.implementation.CustomerDaoImpl;
import com.jet.position.dto.CustomerDto;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @project position
 * @version 1.0
 * @author MENDJIJET
 * @since 16/07/2024
 */
@JdbcTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class CustomerDaoImplTest {
  @Autowired JdbcTemplate jdbcTemplate;
  CustomerDao customerDao;

  @Test
  void shouldReturnListOfCustomers() {
    // Arrange /Given
    customerDao = new CustomerDaoImpl(jdbcTemplate);
    // Act /When
    List<CustomerDto> customerList = this.customerDao.search();

    // Assert /Then
    assertEquals(3, customerList.size());
  }
}
