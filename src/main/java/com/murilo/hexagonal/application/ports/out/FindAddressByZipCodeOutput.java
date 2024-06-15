package com.murilo.hexagonal.application.ports.out;

import com.murilo.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutput {

    Address find(String zipCode);
}
