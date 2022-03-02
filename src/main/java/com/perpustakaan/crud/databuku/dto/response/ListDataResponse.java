package com.perpustakaan.crud.databuku.dto.response;


import lombok.Builder;
import lombok.Data;

@Data @Builder
public class ListDataResponse<T> {
    private T daftarBuku;
    private Long totalBuku;
}
