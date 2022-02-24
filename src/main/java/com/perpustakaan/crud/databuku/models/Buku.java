package com.perpustakaan.crud.databuku.models;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "perpustakaan2")
public class Buku {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String bookName;
    private Integer isbn;
    private String bookAuthor;
    private String bookPublisher;

    @Column(name = "created_date")
    private Timestamp createdDate;

}
