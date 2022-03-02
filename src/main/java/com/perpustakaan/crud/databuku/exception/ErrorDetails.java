package com.perpustakaan.crud.databuku.exception;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class ErrorDetails {

    private Boolean status;
    private String message;
    private String data;

}
