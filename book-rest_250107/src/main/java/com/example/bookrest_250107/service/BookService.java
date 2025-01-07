package com.example.bookrest_250107.service;

import com.example.bookrest_250107.dto.BookRequestDto;
import com.example.bookrest_250107.dto.BookResponseDto;

import java.util.List;

/**
 * packageName    : com.example.bookrest_250107.service
 * fileName       : BookService
 * author         : 김재홍
 * date           : 25. 1. 7.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 1. 7.        김재홍       최초 생성
 */
public interface BookService {
    BookResponseDto addBook(BookRequestDto request);

    BookResponseDto getBook(int bno);

    List<BookResponseDto> getList();

    BookResponseDto updateBook(BookRequestDto request);

    void deleteBook();

}
