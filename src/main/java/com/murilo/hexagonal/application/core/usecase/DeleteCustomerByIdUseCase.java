package com.murilo.hexagonal.application.core.usecase;

import com.murilo.hexagonal.application.ports.in.DeleteCustomerByIdInput;
import com.murilo.hexagonal.application.ports.in.FindCustomerByIdInput;
import com.murilo.hexagonal.application.ports.out.DeleteCustomerByIdOutput;

public class DeleteCustomerByIdUseCase implements DeleteCustomerByIdInput {

    private final FindCustomerByIdInput findCustomerByIdInput;

    private final DeleteCustomerByIdOutput deleteCustomerByIdOutput;

    public DeleteCustomerByIdUseCase
            (
                    FindCustomerByIdInput findCustomerByIdInput,
                    DeleteCustomerByIdOutput deleteCustomerByIdOutput
            ) {
        this.findCustomerByIdInput = findCustomerByIdInput;
        this.deleteCustomerByIdOutput = deleteCustomerByIdOutput;
    }

    @Override
    public void delete(String id) {
        findCustomerByIdInput.find(id);
        deleteCustomerByIdOutput.delete(id);
    }
}
