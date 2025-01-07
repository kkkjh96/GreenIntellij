package com.example.bookrest_250107.controller;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * packageName    : com.example.bookrest_250107.controller
 * fileName       : CustomErrorController
 * author         : 김재홍
 * date           : 25. 1. 7.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 1. 7.        김재홍       최초 생성
 */
@RestController
@RequestMapping("/error")
@Hidden
@RequiredArgsConstructor
@Slf4j
public class CustomErrorController {

    @GetMapping
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFoundException() {
        log.error("404 Not Found");

        return "The requested URL was not found";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleError2() {

        log.error("400 Bad Request");

        return "The requested was wrong";
    }

}
