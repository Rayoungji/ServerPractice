package com.practice.domain.notice;


import com.practice.web.notice.dto.NoticeUpdateDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String author;

    @Builder
    public Notice(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(NoticeUpdateDto noticeUpdateDto) {
        this.title = noticeUpdateDto.getTitle();
        this.content = noticeUpdateDto.getContent();
    }
}
