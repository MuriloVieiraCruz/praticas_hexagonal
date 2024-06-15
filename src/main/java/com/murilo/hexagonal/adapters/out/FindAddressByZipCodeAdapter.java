package com.murilo.hexagonal.adapters.out;

import com.murilo.hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import com.murilo.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import com.murilo.hexagonal.adapters.out.client.response.AddressResponse;
import com.murilo.hexagonal.application.core.domain.Address;
import com.murilo.hexagonal.application.ports.out.FindAddressByZipCodeOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutput {

    @Autowired
    private FindAddressByZipCodeClient findAddressByZipCodeClient;

    @Autowired
    private AddressResponseMapper addressResponseMapper;


    @Override
    public Address find(String zipCode) {
        AddressResponse addressResponse = findAddressByZipCodeClient.find(zipCode);
        return addressResponseMapper.mapToAddress(addressResponse);
    }
}
