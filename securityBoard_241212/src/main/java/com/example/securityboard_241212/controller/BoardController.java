package com.example.securityboard_241212.controller;

import com.example.securityboard_241212.dto.BoardDto;
import com.example.securityboard_241212.security.CustomUserDetails;
import com.example.securityboard_241212.service.BoardService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * packageName    : com.example.securityboard_241212.controller
 * fileName       : BoardController
 * author         : GGG
 * date           : 24. 12. 12.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 12.        GGG       최초 생성
 */

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService boardService; // DI(Dependency Injection)

    @GetMapping("/list")
    public String boardList(Model model, HttpSession session) {

        List<BoardDto> boards = boardService.getBoardList();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

        session.setAttribute("user", userDetails); // 로그인한 user정보를 session attribute로 저장.

        model.addAttribute("boards", boards);  // boards를 model attribute로 전송, view에서 boards를 사용 가능.

        return "/board/list";
    }

    @GetMapping("/write")
    public String writeForm() {
        return "/board/write";
    }

    @PostMapping("/write")
    public String write(BoardDto boardDto) {
        int result = boardService.writeBoard(boardDto);

        if (result > 0) {
            return "redirect:/board/list";
        } else {
            return "/board/write";
        }
    }

    @GetMapping("/detail/{bno}")
    public String detail(@PathVariable("bno") int bno, Model model) {


        BoardDto board = boardService.getBoardByBno(bno);

        model.addAttribute("board", board);

        return "/board/detail"; // TODO: board detail view"
    }

    @GetMapping("/modify/{bno}")
    public String modifyForm(@PathVariable("bno") int bno, Model model) {

        BoardDto board = boardService.getBoardByBno(bno);

        model.addAttribute("board", board);

        return "/board/modify"; // TODO: board modify view"
    }

    @PostMapping("/modify")
    public String modify(BoardDto boardDto) {
        int result = boardService.updateBoard(boardDto);

        if (result > 0) {
            return "redirect:/board/list";
        } else {
            return "/board/modify";
        }
    }

    @GetMapping("/delete/{bno}")
    public String delete(@PathVariable("bno") int bno) {
        int result = boardService.deleteBoard(bno);

        if (result > 0) {
            return "redirect:/board/list";
        } else {
            return "redirect:/board/detail/" + bno;
        }
    }

}
