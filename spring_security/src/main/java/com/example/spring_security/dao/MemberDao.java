package com.example.spring_security.dao;

import com.example.spring_security.entity.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemberDao {

    public int regist(@Param("member") Member member);

    public Member findByUsername(String username);


}
