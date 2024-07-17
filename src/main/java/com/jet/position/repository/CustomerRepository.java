package com.jet.position.repository;

import com.jet.position.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @project position
 * @version 1.0
 * @author MENDJIJET
 * @since 16/07/2024
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {}
