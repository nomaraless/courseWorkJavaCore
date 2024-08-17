package com.example.nomaralessnomad.customeException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;

@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
public class MethodNotAllowed extends RuntimeException {
    public MethodNotAllowed() {
        super("Method not allowed");
    }

    public MethodNotAllowed(String message) {
        super(message);
    }


}
