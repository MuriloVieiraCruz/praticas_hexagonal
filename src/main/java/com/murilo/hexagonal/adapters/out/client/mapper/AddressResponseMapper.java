package com.murilo.hexagonal.adapters.out.client.mapper;

import com.murilo.hexagonal.adapters.out.client.response.AddressResponse;
import com.murilo.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address mapToAddress(AddressResponse addressResponse);
}
