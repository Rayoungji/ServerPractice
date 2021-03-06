package com.practice.domain.notice.domain;


import com.practice.domain.JpaBasePersistable;
import com.practice.domain.notice.dto.NoticeUpdateDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AttributeOverride(name = "id", column = @Column(name = "notice_id"))
public class Notice extends JpaBasePersistable {

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
