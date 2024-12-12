package com.example.securityboard_241212.dao;

import com.example.securityboard_241212.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * packageName    : com.example.securityboard_241212.dao
 * fileName       : BoardDao
 * author         : GGG
 * date           : 24. 12. 12.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 12.        GGG       최초 생성
 */
@Mapper
public interface BoardDao {

    List<BoardDto> selectAllBoards();
    int insertBoard(@Param("board") BoardDto boardDto);
    BoardDto getBoardByBno(int bno);
    int updateBoard(@Param("board") BoardDto boardDto);
    int deleteBoardByBno(int bno);

}
