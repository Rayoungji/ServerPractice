package com.practice.domain.notice.controller;


import com.practice.domain.notice.domain.Notice;
import com.practice.domain.notice.service.NoticeService;
import com.practice.domain.notice.dto.NoticeGetDto;
import com.practice.domain.notice.dto.NoticeSaveDto;
import com.practice.domain.notice.dto.NoticeUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    //모든 공고 조회
    @PostMapping("/list")
    public List<NoticeGetDto> getAllNotices(){
        //-> java8의 람다식 : NoticeRepository로 호출한 Notices리스트들을 NoticeGetDto리스트로 변환하는 메소드//
        return noticeService.getAllNotices().stream().map(NoticeGetDto::new).collect(Collectors.toList());
    }

    //수정
    @PutMapping("/{id}")
    public Notice updateNotice(@PathVariable Long id, @RequestBody NoticeUpdateDto noticeUpdateDto) {
        return noticeService.updateNotice(id, noticeUpdateDto);
    }

    @DeleteMapping("/{id}")
    public void deleteNotice(@PathVariable Long id){
        noticeService.deleteNotice(id);
    }
}
