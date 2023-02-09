package com.study.Board.service;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.study.Board.entity.Board;
import com.study.Board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.border.Border;
import java.util.List;


@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    public void write(Board board) {
        boardRepository.save(board);
    }

    public List<Board> boardList() {
        return boardRepository.findAll();
    }

    public Board boardView(Integer id) {
        return boardRepository.findById(id).get();
    }

    public void boardDelete(Integer id) {

        boardRepository.deleteById(id);
    }

}

