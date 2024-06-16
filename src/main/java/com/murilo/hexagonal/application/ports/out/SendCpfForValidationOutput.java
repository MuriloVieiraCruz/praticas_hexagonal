package com.murilo.hexagonal.application.ports.out;

public interface SendCpfForValidationOutput {

    void send(String cpf);
}
