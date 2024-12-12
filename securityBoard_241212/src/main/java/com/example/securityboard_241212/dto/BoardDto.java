package com.example.securityboard_241212.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * packageName    : com.example.securityboard_241212.dto
 * fileName       : BoardDto
 * author         : 김재홍
 * date           : 24. 12. 12.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 12.        김재홍       최초 생성
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDto {

    private int bno;
    private String title;
    private String content;
    private String writer;
    private String regDate;

}
