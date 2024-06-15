package com.murilo.hexagonal.application.core.usecase;

import com.murilo.hexagonal.application.core.domain.Address;
import com.murilo.hexagonal.application.core.domain.Customer;
import com.murilo.hexagonal.application.ports.in.FindCustomerByIdInput;
import com.murilo.hexagonal.application.ports.in.UpdateCustomerInput;
import com.murilo.hexagonal.application.ports.out.FindAddressByZipCodeOutput;
import com.murilo.hexagonal.application.ports.out.UpdateCustomerOutput;

public class UpdateCustomerUseCase implements UpdateCustomerInput {

    private final FindCustomerByIdInput findCustomerByIdInput;

    private final FindAddressByZipCodeOutput findAddressByZipCodeOutput;

    private final UpdateCustomerOutput updateCustomerOutput;

    public UpdateCustomerUseCase
            (
                    FindCustomerByIdInput findCustomerByIdInput,
                    UpdateCustomerOutput updateCustomerOutput,
                    FindAddressByZipCodeOutput findAddressByZipCodeOutput
            ) {
        this.findAddressByZipCodeOutput = findAddressByZipCodeOutput;
        this.findCustomerByIdInput = findCustomerByIdInput;
        this.updateCustomerOutput = updateCustomerOutput;
    }

    @Override
    public void update(Customer customer, String zipCode) {
        findCustomerByIdInput.find(customer.getId());
        Address address = findAddressByZipCodeOutput.find(zipCode);
        customer.setAddress(address);

        updateCustomerOutput.update(customer);
    }
}
