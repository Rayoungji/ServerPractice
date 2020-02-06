package com.practice.web.notice.dto;

import com.practice.domain.notice.Notice;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class NoticeGetDto {
    private Long id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime modifiedDate;

    public NoticeGetDto(Notice notice) {
        this.id=notice.getId();
        this.title = notice.getTitle();
        this.content = notice.getContent();
        this.author = notice.getAuthor();
        this.modifiedDate=notice.getModifiedDate();
    }
}
