package com.murilo.hexagonal.adapters.in.controller;

import com.murilo.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.murilo.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.murilo.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.murilo.hexagonal.application.core.domain.Customer;
import com.murilo.hexagonal.application.ports.in.FindCustomerByIdInput;
import com.murilo.hexagonal.application.ports.in.InsertCustomerInput;
import com.murilo.hexagonal.application.ports.in.UpdateCustomerInput;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private InsertCustomerInput insertCustomerInput;

    @Autowired
    private FindCustomerByIdInput findCustomerByIdInput;

    @Autowired
    private UpdateCustomerInput updateCustomerInput;

    @Autowired
    private CustomerMapper customerMapper;

    @PostMapping("/create")
    public ResponseEntity<Void> insert(@RequestBody @Valid CustomerRequest customer) {
        insertCustomerInput.insert(customerMapper.mapToCustomer(customer), customer.getZipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> find(@PathVariable final String id) {
        CustomerResponse customerResponse = customerMapper.mapToCustomerResponse(findCustomerByIdInput.find(id));
        return ResponseEntity.ok().body(customerResponse);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> update(@PathVariable final String id, @RequestBody @Valid CustomerRequest customerRequest) {
        Customer customer = customerMapper.mapToCustomer(customerRequest);
        customer.setId(id);
        updateCustomerInput.update(customer, customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }
}
