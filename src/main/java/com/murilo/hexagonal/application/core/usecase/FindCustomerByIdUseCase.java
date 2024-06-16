package com.murilo.hexagonal.application.core.usecase;

import com.murilo.hexagonal.application.core.domain.Customer;
import com.murilo.hexagonal.application.ports.in.FindCustomerByIdInput;
import com.murilo.hexagonal.application.ports.out.FindCustomerByIdOutput;

public class FindCustomerByIdUseCase implements FindCustomerByIdInput {

    private final FindCustomerByIdOutput findCustomerByIdOutput;

    public FindCustomerByIdUseCase(FindCustomerByIdOutput findCustomerByIdOutput) {
        this.findCustomerByIdOutput = findCustomerByIdOutput;
    }

    @Override
    public Customer find(String id) {
        return findCustomerByIdOutput.find(id).orElseThrow(() -> new RuntimeException("Customer not found"));
    }
}
