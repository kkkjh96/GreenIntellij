package com.example.security2_241212.dao;

import com.example.security2_241212.entity.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemberDao {

    void insertMember(@Param("member") Member member);

    Member findByUsername(String id);

}
