package com.murilo.hexagonal.application.ports.in;

import com.murilo.hexagonal.application.core.domain.Customer;

public interface InsertCustomerInput {

    void insert(Customer customer, String zipCode);
}
