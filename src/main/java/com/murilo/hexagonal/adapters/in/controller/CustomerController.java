package com.murilo.hexagonal.adapters.in.controller;

import com.murilo.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.murilo.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.murilo.hexagonal.application.ports.in.InsertCustomerInput;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private InsertCustomerInput insertCustomerInput;

    @Autowired
    private CustomerMapper customerMapper;

    @PostMapping("/create")
    public ResponseEntity<Void> insert(@RequestBody @Valid CustomerRequest customer) {
        insertCustomerInput.insert(customerMapper.mapToCustomer(customer), customer.getZipCode());
        return ResponseEntity.ok().build();
    }
}
