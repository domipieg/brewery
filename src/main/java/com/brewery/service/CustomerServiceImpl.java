package com.brewery.service;

import com.brewery.model.BeerDto;
import com.brewery.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public CustomerDto getCustomerById(UUID id) {
        return CustomerDto.builder().id(UUID.randomUUID()).name("Dominik").build();
    }

    @Override
    public BeerDto saveNewCustomer(CustomerDto customerDto) {
        return null;
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDto customerDto) {

    }

    @Override
    public void deleteCustomer(UUID beerId) {

    }
}
