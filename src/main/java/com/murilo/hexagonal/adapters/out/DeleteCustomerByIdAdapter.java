package com.murilo.hexagonal.adapters.out;

import com.murilo.hexagonal.adapters.out.repository.CustomerRepository;
import com.murilo.hexagonal.application.ports.out.DeleteCustomerByIdOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerByIdAdapter implements DeleteCustomerByIdOutput {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void delete(String id) {
        customerRepository.deleteById(id);
    }
}
