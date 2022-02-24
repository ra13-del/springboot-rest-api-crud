package com.perpustakaan.crud.databuku.repositories;

import com.perpustakaan.crud.databuku.models.Buku;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BukuRepository extends JpaRepository<Buku, Integer> {
}
