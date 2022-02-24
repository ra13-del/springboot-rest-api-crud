package com.perpustakaan.crud.databuku.dto.request;


import lombok.Builder;
import lombok.Data;

@Data @Builder

public class DataRequest {
    private String bookName;
    private Integer isbn;
    private String bookAuthor;
    private String bookPublisher;
}
