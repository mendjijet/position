package com.jet.position.services;

import com.jet.position.dto.CustomerDto;

import java.util.List;

/**
 * @project position
 * @version 1.0
 * @author MENDJIJET
 * @since 16/07/2024
 */
public interface CustomerService {
    List<CustomerDto> search();
    CustomerDto read(int id);
}
