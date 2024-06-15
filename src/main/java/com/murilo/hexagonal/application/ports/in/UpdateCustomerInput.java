package com.murilo.hexagonal.application.ports.in;

import com.murilo.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerInput {

    void update(Customer customer, String zipCode);
}
