package com.example.bookrest_250107.dto;

import com.example.bookrest_250107.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * packageName    : com.example.bookrest_250107.dto
 * fileName       : BookResponseDto
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
public class BookResponseDto {

    private Integer bno;
    private String title;
    private String author;
    private String publisher;
    private int price;
    private String info;

    public static BookResponseDto toBook(Book book){

        return BookResponseDto.builder()
                .bno(book.getBno())
                .title(book.getTitle())
                .author(book.getAuthor())
                .publisher(book.getPublisher())
                .price(book.getPrice())
                .info(book.getInfo())
                .build();

    }


}
