package com.example.securityboard_241212.service;

import com.example.securityboard_241212.dao.BoardDao;
import com.example.securityboard_241212.dto.BoardDto;
import com.example.securityboard_241212.security.CustomUserDetails;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName    : com.example.securityboard_241212.service
 * fileName       : BoardServiceImpl
 * author         : GGG
 * date           : 24. 12. 12.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 12.        GGG       최초 생성
 */
@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    BoardDao boardDao;


    @Override
    public List<BoardDto> getBoardList() {

        return boardDao.selectAllBoards();

    }

    @Override
    public int writeBoard(BoardDto boardDto) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

        boardDto.setWriter(userDetails.getUsername());

        return boardDao.insertBoard(boardDto);
    }

    @Override
    public BoardDto getBoardByBno(int id) {

        return boardDao.getBoardByBno(id);
    }

    @Override
    public int updateBoard(BoardDto boardDto) {

        return boardDao.updateBoard(boardDto);
    }

    @Override
    public int deleteBoard(int bno) {

        return boardDao.deleteBoardByBno(bno);
    }
}
