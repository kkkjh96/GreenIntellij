package com.example.bookrest_250107.repository;

import com.example.bookrest_250107.dto.BookResponseDto;
import com.example.bookrest_250107.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * packageName    : com.example.bookrest_250107.repository
 * fileName       : BookRepository
 * author         : 김재홍
 * date           : 25. 1. 7.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 1. 7.        김재홍       최초 생성
 */
public interface BookRepository extends JpaRepository<Book, Integer> {

    Book findByTitle(String title);

}
