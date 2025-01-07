package com.example.bookrest_250107.service;

import com.example.bookrest_250107.dto.BookRequestDto;
import com.example.bookrest_250107.dto.BookResponseDto;
import com.example.bookrest_250107.entity.Book;
import com.example.bookrest_250107.repository.BookRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * packageName    : com.example.bookrest_250107.service
 * fileName       : BookServiceImpl
 * author         : 김재홍
 * date           : 25. 1. 7.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 1. 7.        김재홍       최초 생성
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    @Transactional
    public BookResponseDto addBook(BookRequestDto request){

        Book book = request.toBook();

        log.info("Book" + book);

        Book bk = bookRepository.save(book);

        return BookResponseDto.toBook(bk);
    }

    @Override
    public BookResponseDto getBook(int bno){

        Optional<Book> bk = bookRepository.findById(bno);

        Book book = new Book();
        book.setBno(bk.get().getBno());
        book.setTitle(bk.get().getTitle());
        book.setAuthor(bk.get().getAuthor());
        book.setPublisher(bk.get().getPublisher());
        book.setPrice(bk.get().getPrice());
        book.setInfo(bk.get().getInfo());

        return BookResponseDto.toBook(book);

    }

    @Override
    public List<BookResponseDto> getList(){

        List<Book> books = bookRepository.findAll();

        List<BookResponseDto> responseDtos = new ArrayList<>();

        for(Book book : books){
            log.info("Book" + book);
            BookResponseDto responseDto = BookResponseDto.toBook(book);

            responseDtos.add(responseDto);
        }

        return responseDtos;

    }

    @Override
    public BookResponseDto updateBook(BookRequestDto request) {

        Book book = request.toBook();

        log.info("Book" + book);

        Book bk = bookRepository.save(book);

        return BookResponseDto.toBook(bk);
    }

    @Override
    public void deleteBook(){

    }

}
