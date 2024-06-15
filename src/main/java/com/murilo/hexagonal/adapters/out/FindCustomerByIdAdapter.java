package com.murilo.hexagonal.adapters.out;

import com.murilo.hexagonal.adapters.out.repository.CustomerRepository;
import com.murilo.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.murilo.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.murilo.hexagonal.application.core.domain.Customer;
import com.murilo.hexagonal.application.ports.out.FindCustomerByIdOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByIdAdapter implements FindCustomerByIdOutput {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public Optional<Customer> find(String id) {
        Optional<CustomerEntity> customerEntity = customerRepository.findById(id);
        return customerEntity.map(customerEntityMapper::mapToCustomer);
    }
}
