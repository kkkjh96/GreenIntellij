package com.example.securityboard_241212.service;

import com.example.securityboard_241212.dto.BoardDto;
import jakarta.servlet.http.HttpSession;

import java.util.List;

/**
 * packageName    : com.example.securityboard_241212.service
 * fileName       : BoardService
 * author         : GGG
 * date           : 24. 12. 12.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 12.        GGG       최초 생성
 */
public interface BoardService {

    List<BoardDto> getBoardList();

    int writeBoard(BoardDto boardDto);

    BoardDto getBoardByBno(int id);

    int updateBoard(BoardDto boardDto);

    int deleteBoard(int id);

}
