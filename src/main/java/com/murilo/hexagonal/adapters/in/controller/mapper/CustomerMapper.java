package com.murilo.hexagonal.adapters.in.controller.mapper;

import com.murilo.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.murilo.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    Customer mapToCustomer(CustomerRequest customerRequest);
}
