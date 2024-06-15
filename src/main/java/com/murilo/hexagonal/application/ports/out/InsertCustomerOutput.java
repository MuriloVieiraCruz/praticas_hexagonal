package com.murilo.hexagonal.application.ports.out;

import com.murilo.hexagonal.application.core.domain.Customer;

public interface InsertCustomerOutput {

    void insert(Customer customer);
}
