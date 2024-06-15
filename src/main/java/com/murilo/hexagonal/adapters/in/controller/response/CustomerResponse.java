package com.murilo.hexagonal.adapters.in.controller.response;

import com.murilo.hexagonal.application.core.domain.Address;
import lombok.Data;

@Data
public class CustomerResponse {

    private String name;

    private AddressResponse address;

    private String cpf;
}
