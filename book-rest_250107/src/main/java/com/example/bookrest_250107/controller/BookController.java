package com.example.bookrest_250107.controller;

import com.example.bookrest_250107.dto.BookRequestDto;
import com.example.bookrest_250107.dto.BookResponseDto;
import com.example.bookrest_250107.service.BookService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * packageName    : com.example.bookrest_250107.controller
 * fileName       : BookController
 * author         : 김재홍
 * date           : 25. 1. 7.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 1. 7.        김재홍       최초 생성
 */
@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
@Slf4j
@OpenAPIDefinition(
        info = @Info(title =  "Book Rest API", version = "1.0", description="내가 본 책들")
)
public class BookController {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<Object> addBook(@RequestBody BookRequestDto requestDto){

        Map<String, Object> responseMap = new HashMap<>();

        try{
            BookResponseDto response = bookService.addBook(requestDto);

            responseMap.put("status", "201(CREATE)");
            responseMap.put("body", response);
            return ResponseEntity.ok(responseMap);  // 성공 : 201(CREATE) -> 등록된 책정보
        } catch (Exception e) {
            responseMap.put("status", "400(ERROR)");
            responseMap.put("message", "책 등록에 실패 했습니다.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseMap);
        }
    }

    @GetMapping
    public ResponseEntity<Object> getBook(@RequestParam int bno){

        Map<String, Object> responseMap = new HashMap<>();

        try{
            BookResponseDto response = bookService.getBook(bno);

            responseMap.put("status", "200(OK)");
            responseMap.put("body", response);
            return ResponseEntity.ok(responseMap);     // 성공 : 200(OK) -> ��정보
        } catch (Exception e) {
            responseMap.put("status", "404(NOT_FOUND)");
            responseMap.put("message", "책정보를 찾을 수 없습니다.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseMap);   // 실패 : 404(NOT_FOUND) -> 책정보를 찾을 수 없습니다.
        }

    }

    @GetMapping("/list")
    public ResponseEntity<Object> getBookList(){

        Map<String, Object> responseMap = new HashMap<>();

        try{
            List<BookResponseDto> response = bookService.getList();

            responseMap.put("status", "200(OK)");
            responseMap.put("body", response);
            return ResponseEntity.ok(responseMap);     // 성공 : 200(OK) -> ��정보
        } catch (Exception e) {
            responseMap.put("status", "404(NOT_FOUND)");
            responseMap.put("message", "책정보를 찾을 수 없습니다.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseMap);   // 실패 : 404(NOT_FOUND) -> 책정보를 찾을 수 없습니다.
        }

    }

    @PutMapping("/{bno}")
    public ResponseEntity<Object> updateBook(@PathVariable("bno") int bno, @RequestBody BookRequestDto requestDto){

        Map<String, Object> responseMap = new HashMap<>();

        try{
            BookResponseDto book = bookService.getBook(bno);
            BookResponseDto response = new BookResponseDto();
            if(book != null){
                requestDto.setBno(book.getBno()); // bno는 update할 때만 있어야 함
                response = bookService.updateBook(requestDto);
            }

            responseMap.put("status", "200(OK)");
            responseMap.put("body", response);
            return ResponseEntity.ok(responseMap);  // 성공 : 200(OK) -> 업데이트된 책정보
        } catch (Exception e) {
            responseMap.put("status", "400(ERROR)");
            responseMap.put("message", "책 정보 수정에 실패 했습니다.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseMap);
        }

    }

    @DeleteMapping
    public ResponseEntity<Object> deleteBook(@RequestParam int bno){

        return null;    // 성공 : 200(OK) -> 삭제되었습니다.

    }

}
