package com.perpustakaan.crud.databuku.dto.response;


import lombok.Builder;
import lombok.Data;

@Data @Builder
public class ErrorDataResponse {

    private Boolean success;
    private String message;
    private String data;

}
