package com.softuni.demo.domain.dtos;

public class GameTitleDto {
    private String title;

    public GameTitleDto() {}

    public GameTitleDto(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
