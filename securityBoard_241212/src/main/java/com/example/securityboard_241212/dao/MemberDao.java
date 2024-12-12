package com.example.securityboard_241212.dao;

import com.example.securityboard_241212.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * packageName    : com.example.securityboard_241212.dao
 * fileName       : MemberDao
 * author         : GGG
 * date           : 24. 12. 12.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 12.        GGG       최초 생성
 */
@Mapper
public interface MemberDao {

    int insertMember(@Param("member") MemberDto member);

    MemberDto findByUsername(String username);
}
