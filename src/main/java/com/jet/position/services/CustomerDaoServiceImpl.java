package com.jet.position.services;

import com.jet.position.dao.CustomerDao;
import com.jet.position.dto.CustomerDto;
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
public class CustomerDaoServiceImpl implements CustomerService {
  CustomerDao customerDao;

  @Override
  public List<CustomerDto> search() {
    return this.customerDao.search();
  }

  @Override
  public CustomerDto read(int id) {
    return null;
  }
}
