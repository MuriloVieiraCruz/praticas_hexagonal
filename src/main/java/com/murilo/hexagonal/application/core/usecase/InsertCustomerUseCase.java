package com.murilo.hexagonal.application.core.usecase;

import com.murilo.hexagonal.application.core.domain.Address;
import com.murilo.hexagonal.application.core.domain.Customer;
import com.murilo.hexagonal.application.ports.in.InsertCustomerInput;
import com.murilo.hexagonal.application.ports.out.FindAddressByZipCodeOutput;
import com.murilo.hexagonal.application.ports.out.InsertCustomerOutput;
import com.murilo.hexagonal.application.ports.out.SendCpfForValidationOutput;

public class InsertCustomerUseCase implements InsertCustomerInput {

    private final FindAddressByZipCodeOutput findAddressByZipCodeOutput;

    private final InsertCustomerOutput insertCustomerOutput;

    private final SendCpfForValidationOutput sendCpfForValidationOutput;

    public InsertCustomerUseCase
            (
                    FindAddressByZipCodeOutput findAddressByZipCodeOutput,
                    InsertCustomerOutput insertCustomerOutput,
                    SendCpfForValidationOutput sendCpfForValidationOutput
            ) {
        this.insertCustomerOutput = insertCustomerOutput;
        this.findAddressByZipCodeOutput = findAddressByZipCodeOutput;
        this.sendCpfForValidationOutput = sendCpfForValidationOutput;
    }

    @Override
    public void insert(Customer customer, String zipCode) {
        Address address = findAddressByZipCodeOutput.find(zipCode);
        customer.setAddress(address);

        insertCustomerOutput.insert(customer);
        sendCpfForValidationOutput.send(customer.getCpf());
    }
}
