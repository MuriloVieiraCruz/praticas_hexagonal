package com.murilo.hexagonal.application.ports.out;

import com.murilo.hexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdOutput {

    Optional<Customer> find(String id);
}
