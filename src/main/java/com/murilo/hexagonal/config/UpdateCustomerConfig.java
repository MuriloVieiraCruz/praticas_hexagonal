package com.murilo.hexagonal.config;

import com.murilo.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.murilo.hexagonal.adapters.out.FindCustomerByIdAdapter;
import com.murilo.hexagonal.adapters.out.UpdateCustomerAdapter;
import com.murilo.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.murilo.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            UpdateCustomerAdapter updateCustomerAdapter
    ) {
        return new UpdateCustomerUseCase(findCustomerByIdUseCase, updateCustomerAdapter, findAddressByZipCodeAdapter);
    }
}
