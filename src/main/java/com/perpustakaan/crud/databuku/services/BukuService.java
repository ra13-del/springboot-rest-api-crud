package com.perpustakaan.crud.databuku.services;

import com.perpustakaan.crud.databuku.dto.request.DataRequest;
import com.perpustakaan.crud.databuku.dto.response.DataResponse;
import com.perpustakaan.crud.databuku.models.Buku;

import java.util.List;
import java.util.Optional;

public interface BukuService {
    List<Buku> getAllBuku();

    DataResponse addBuku(DataRequest request);

    Optional<Buku> getById(Integer id);

    String deleteBuku(Integer id);

    DataResponse updateBuku(DataRequest request, Integer id);
}
