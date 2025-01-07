package com.example.bookrest_250107.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * packageName    : com.example.bookrest_250107.entity
 * fileName       : Book
 * author         : 김재홍
 * date           : 25. 1. 7.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 1. 7.        김재홍       최초 생성
 */
@Entity
@Table(name = "tbl_book")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bno;
    private String title;
    private String author;
    private String publisher;
    private int price;
    private String info;

}
