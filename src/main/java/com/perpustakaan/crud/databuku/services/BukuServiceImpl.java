package com.perpustakaan.crud.databuku.services;


import com.perpustakaan.crud.databuku.dto.request.DataRequest;
import com.perpustakaan.crud.databuku.dto.response.DataResponse;
import com.perpustakaan.crud.databuku.models.Buku;
import com.perpustakaan.crud.databuku.repositories.BukuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class BukuServiceImpl implements BukuService {

    @Autowired
    private BukuRepository bukuRepository;

//Create
    @Override
    public DataResponse addBuku(DataRequest request) {
        Buku buku = bukuRepository.save(Buku.builder()
                .bookName(request.getBookName())
                .isbn(request.getIsbn())
                .bookAuthor(request.getBookAuthor())
                .bookPublisher(request.getBookPublisher())
                .createdDate(new Timestamp(System.currentTimeMillis()))
                .build());
        return DataResponse.builder()
                .success(true)
                .message("Added")
                .data(buku)
                .build();
    }

//Read
    @Override
    public List<Buku> getAllBuku() {
        List<Buku> bukuList = bukuRepository.findAll();
        return bukuList;
    }

//ReadById
    @Override
    public Optional<Buku> getById(Integer id) {
        Optional<Buku> buku = bukuRepository.findById(id);
        return buku;
    }

//Update
    @Override
    public DataResponse updateBuku(DataRequest request, Integer id) {

        Buku buku = bukuRepository.findById(id).get();
        buku.setBookName(request.getBookName());
        buku.setIsbn(request.getIsbn());
        buku.setBookAuthor(request.getBookAuthor());
        buku.setBookPublisher(request.getBookPublisher());
        buku.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        Buku dataResponse = bukuRepository.save(buku);
        return DataResponse.builder()
                .success(true)
                .message("Updated")
                .data(dataResponse)
                .build();
    }


//Delete
    @Override
    public String deleteBuku(Integer id) {
        bukuRepository.deleteById(id);
        return "Deleted";
    }

}
