package com.murilo.hexagonal.config;

import com.murilo.hexagonal.adapters.out.DeleteCustomerByIdAdapter;
import com.murilo.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.murilo.hexagonal.adapters.out.UpdateCustomerAdapter;
import com.murilo.hexagonal.application.core.usecase.DeleteCustomerByIdUseCase;
import com.murilo.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.murilo.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerByIdConfig {

    @Bean
    public DeleteCustomerByIdUseCase deleteCustomerByIdUseCase(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            DeleteCustomerByIdAdapter deleteCustomerByIdAdapter
    ) {
        return new DeleteCustomerByIdUseCase(findCustomerByIdUseCase, deleteCustomerByIdAdapter);
    }
}
