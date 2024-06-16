package com.murilo.hexagonal.application.core.usecase;

import com.murilo.hexagonal.application.core.domain.Address;
import com.murilo.hexagonal.application.core.domain.Customer;
import com.murilo.hexagonal.application.ports.in.InsertCustomerInput;
import com.murilo.hexagonal.application.ports.out.FindAddressByZipCodeOutput;
import com.murilo.hexagonal.application.ports.out.InsertCustomerOutput;

public class InsertCustomerUseCase implements InsertCustomerInput {

    private final FindAddressByZipCodeOutput findAddressByZipCodeOutput;

    private final InsertCustomerOutput insertCustomerOutput;

    public InsertCustomerUseCase(FindAddressByZipCodeOutput findAddressByZipCodeOutput, InsertCustomerOutput insertCustomerOutput) {
        this.insertCustomerOutput = insertCustomerOutput;
        this.findAddressByZipCodeOutput = findAddressByZipCodeOutput;
    }

    @Override
    public void insert(Customer customer, String zipCode) {
        Address address = findAddressByZipCodeOutput.find(zipCode);
        customer.setAddress(address);

        insertCustomerOutput.insert(customer);
    }
}
