package com.jet.position.controller;

import com.jet.position.dto.CustomerDto;
import com.jet.position.services.CustomerService;
import com.jet.position.services.CustomerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @project position
 * @version 1.0
 * @author MENDJIJET
 * @since 16/07/2024
 */

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "customers")
public class CustomerController {

    private final CustomerServiceImpl customerService;

    @GetMapping
    public List<CustomerDto> search(){
        return customerService.search();
    }

    @GetMapping(path = "{id}")
    public CustomerDto search(@PathVariable int id){
        return customerService.read(id);
    }
}
