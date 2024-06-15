package com.murilo.hexagonal.adapters.out;

import com.murilo.hexagonal.adapters.out.repository.CustomerRepository;
import com.murilo.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.murilo.hexagonal.application.core.domain.Customer;
import com.murilo.hexagonal.application.ports.out.UpdateCustomerOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerAdapter implements UpdateCustomerOutput {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void update(Customer customer) {
        customerRepository.save(customerEntityMapper.mapToCustomerEntity(customer));
    }
}
