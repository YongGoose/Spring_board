package com.study.Board.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Board")
public class Board {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;

    public Board() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
