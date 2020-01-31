package com.practice.web.notice.controller;


import com.practice.domain.notice.Notice;
import com.practice.service.notice.NoticeService;
import com.practice.web.notice.dto.NoticeGetDto;
import com.practice.web.notice.dto.NoticeSaveDto;
import com.practice.web.notice.dto.NoticeUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/notice")
@RequiredArgsConstructor
public class NoticeController {
    private final NoticeService noticeService;

    @PostMapping
    public Long saveNotice(@RequestBody NoticeSaveDto noticeSaveDto) {
        return noticeService.saveNotice(noticeSaveDto.toEntity());
    }

    @GetMapping("/{id}")
    public NoticeGetDto getNotice(@PathVariable Long id) {
        return new NoticeGetDto(noticeService.getNotice(id));
    }

    @PutMapping("/{id}")
    public Notice updateNotice(@PathVariable Long id, @RequestBody NoticeUpdateDto noticeUpdateDto) {
        return noticeService.updateNotice(id, noticeUpdateDto);
    }
}
