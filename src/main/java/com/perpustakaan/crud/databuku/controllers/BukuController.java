package com.perpustakaan.crud.databuku.controllers;


import com.perpustakaan.crud.databuku.dto.request.DataRequest;
import com.perpustakaan.crud.databuku.dto.response.DataResponse;
import com.perpustakaan.crud.databuku.dto.response.ErrorDataResponse;
import com.perpustakaan.crud.databuku.dto.response.ListDataResponse;
import com.perpustakaan.crud.databuku.models.Buku;
import com.perpustakaan.crud.databuku.services.BukuService;
//import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
//@Slf4j
public class BukuController {

    @Autowired
    private BukuService bukuService;

    @PostMapping("/buku")
    public ResponseEntity<?> addBuku(@RequestBody DataRequest request) {
//        log.info("bookName : {}", request.getBookName());
//        log.info("isbn : {}", request.getIsbn());
//        log.info("bookAuthor : {}", request.getBookAuthor());
//        log.info("bookPublisher: {}", request.getBookPublisher());
        DataResponse dataResponse = bukuService.addBuku(request);
        return ResponseEntity.ok().body(dataResponse);
    }

    @GetMapping("/buku")
    public ResponseEntity<?> findAllBuku(@RequestHeader("Authorization") String auth) {
        try {
            List<Buku> bukuList = bukuService.getAllBuku();
            return ResponseEntity.ok().body(DataResponse.builder()
                    .success(true)
                    .message("Success")
                    .data(ListDataResponse.builder()
                            .daftarBuku(bukuList)
                            .totalBuku((long) bukuList.size())
                            .build())
                    .build());
        } catch (Exception e) {
            return ResponseEntity.ok().body(ErrorDataResponse.builder()
                    .success(false)
                    .message("Kita coba")
                    .data("null")
                    .build());
        }

    }

    @GetMapping("/buku/{id}")
    public ResponseEntity<?> bukuById(@PathVariable Integer id) {
        Optional<Buku> buku = bukuService.getById(id);
        return ResponseEntity.ok().body(DataResponse.builder()
                .success(true)
                .message("Success")
                .data(ListDataResponse.builder()
                        .daftarBuku(buku)
                        .totalBuku((long) 1)
                        .build())
                .build());
    }

    @PutMapping("/buku/{id}")
    public ResponseEntity<?> updateBuku(@RequestBody DataRequest request, @PathVariable Integer id) {
//        log.info("bookName : {}", request.getBookName());
//        log.info("isbn : {}", request.getIsbn());
//        log.info("bookAuthor : {}", request.getBookAuthor());
//        log.info("bookPublisher: {}", request.getBookPublisher());
        DataResponse dataResponse = bukuService.updateBuku(request, id);
        return ResponseEntity.ok().body(dataResponse);
    }

    @DeleteMapping("/buku/{id}")
    public ResponseEntity<?> deleteBuku(@PathVariable Integer id) {
        String buku = bukuService.deleteBuku(id);
        return ResponseEntity.ok().body(DataResponse.builder()
                .success(true)
                .message("Success")
                .data(buku)
                .build());
    }
}
