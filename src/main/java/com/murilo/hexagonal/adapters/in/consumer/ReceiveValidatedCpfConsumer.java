package com.murilo.hexagonal.adapters.in.consumer;

import com.murilo.hexagonal.adapters.in.consumer.mapper.CustomerMessageMapper;
import com.murilo.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.murilo.hexagonal.application.ports.in.UpdateCustomerInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidatedCpfConsumer {

    @Autowired
    private UpdateCustomerInput updateCustomerInput;

    @Autowired
    private CustomerMessageMapper customerMessageMapper;

    @KafkaListener(topics = "tp-cpf-validated", groupId = "murilo")
    public void receive(CustomerMessage customerMessage) {
        updateCustomerInput.update(customerMessageMapper.mapToCustomer(customerMessage), customerMessage.getZipCode());
    }
}
