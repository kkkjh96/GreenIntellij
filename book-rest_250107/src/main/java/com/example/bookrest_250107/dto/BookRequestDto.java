package com.example.bookrest_250107.dto;

import com.example.bookrest_250107.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * packageName    : com.example.bookrest_250107.dto
 * fileName       : BookRequestDto
 * author         : 김재홍
 * date           : 25. 1. 7.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 1. 7.        김재홍       최초 생성
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookRequestDto {

    private Integer bno;
    private String title;
    private String author;
    private String publisher;
    private Integer price;
    private String info;

    public Book toBook() {
        return Book.builder()
                .bno(bno)
                .title(title)
                .author(author)
                .publisher(publisher)
                .price(price)
                .info(info)
                .build();
    }

}
