package com.murilo.hexagonal.adapters.in.consumer.mapper;

import com.murilo.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.murilo.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface CustomerMessageMapper {

    @Mapping(target = "address", ignore = true)
    Customer mapToCustomer(CustomerMessage customerMessage);
}
