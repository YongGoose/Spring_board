package com.study.Board.controller;

import com.study.Board.entity.Board;
import com.study.Board.service.BoardService;
import org.hibernate.type.StringNVarcharType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping("/board/write") //local:8080/board/write
    public String boardWriteForm() {
        return "boardwrite";
    }

    @PostMapping("/board/writepro")
    public String boardWritePro(Board board, Model model, MultipartFile file) throws Exception {
        boardService.write(board, file);
        model.addAttribute("message", "글 작성이 완료 되었습니다.");
        model.addAttribute("searchUrl", "/board/list");

        return "message";
    }

    @GetMapping("/board/list")
    public String boardList(Model model) {
        model.addAttribute("list", boardService.boardList()); // 이걸 실행시키면 list가 반환되는데 list라는 이름으로 반환된다.
        return "boardlist";
    }

    @GetMapping("/board/view") // localhost:8080/board/view?id=1 하면 id가 1로 전달이 된다.
    public String boardview(Model model, Integer id) {
        model.addAttribute("board", boardService.boardView(id));
        return "boardview";
    }

    @GetMapping("/board/delete")
    public String boardDelete(Integer id) {
        boardService.boardDelete(id);
        return "redirect:/board/list";
    }

    @GetMapping("/board/update/{id}")
    public String boardUpdate(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("board", boardService.boardView(id));
        return "boardupdate";
    }

    @PostMapping("board/change/{id}")
    public String boardChange(@PathVariable("id") Integer id, Board board, MultipartFile file) throws Exception{
        Board board_original = boardService.boardView(id);
        board_original.setTitle(board.getTitle());
        board_original.setContent(board.getContent());

        boardService.write(board_original, file);
        return "redirect:/board/list";
    }
}
