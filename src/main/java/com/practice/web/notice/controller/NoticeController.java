package com.practice.web.notice.controller;


import com.practice.domain.notice.Notice;
import com.practice.service.notice.NoticeService;
import com.practice.web.notice.dto.NoticeGetDto;
import com.practice.web.notice.dto.NoticeSaveDto;
import com.practice.web.notice.dto.NoticeUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/notices")
@RequiredArgsConstructor
public class NoticeController {
    private final NoticeService noticeService;

    //저장
    @PostMapping
    public Long saveNotice(@RequestBody NoticeSaveDto noticeSaveDto) {
        return noticeService.saveNotice(noticeSaveDto.toEntity());
    }

    //조화
    @GetMapping("/{id}")
    public NoticeGetDto getNotice(@PathVariable Long id) {
        return new NoticeGetDto(noticeService.getNotice(id));
    }

    //수정
    @PutMapping("/{id}")
    public Notice updateNotice(@PathVariable Long id, @RequestBody NoticeUpdateDto noticeUpdateDto) {
        return noticeService.updateNotice(id, noticeUpdateDto);
    }
}
