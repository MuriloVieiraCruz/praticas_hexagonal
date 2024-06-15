package com.murilo.hexagonal.adapters.out.repository.mapper;

import com.murilo.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.murilo.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.murilo.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    CustomerEntity mapToCustomerEntity(Customer customer);
}
