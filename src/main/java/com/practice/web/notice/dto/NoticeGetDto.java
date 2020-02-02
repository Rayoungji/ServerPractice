package com.practice.web.notice.dto;

import com.practice.domain.notice.Notice;
import lombok.Getter;

@Getter
public class NoticeGetDto {
    private String title;
    private String content;
    private String author;

    public NoticeGetDto(Notice notice) {
        this.title = notice.getTitle();
        this.content = notice.getContent();
        this.author = notice.getAuthor();
    }
}
