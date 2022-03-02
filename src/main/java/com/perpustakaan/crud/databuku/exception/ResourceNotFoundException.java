package com.perpustakaan.crud.databuku.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ResourceNotFoundException extends Exception {

    private static final long serialVersionUID = -2098699346493915395L;

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
