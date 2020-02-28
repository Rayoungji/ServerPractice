package com.practice.domain.notice.dto;

import com.practice.domain.notice.domain.Notice;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NoticeSaveDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public NoticeSaveDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Notice toEntity() {
        Notice notice = Notice.builder()
                .title(title)
                .content(content)
                .author(author).build();
        return notice;
    }
}
