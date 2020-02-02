package com.practice.service.notice;

import com.practice.domain.notice.Notice;
import com.practice.domain.notice.NoticeRepository;
import com.practice.web.notice.dto.NoticeUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoticeService {
    private final NoticeRepository noticeRepository;

    //공고 등록
    public Long saveNotice(Notice notice) {
        return noticeRepository.save(notice).getId();
    }

    //공고 조회
    public Notice getNotice(Long id) {
        return noticeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 공고 없음"));
    }

    //공고 수정
    public Notice updateNotice(Long id, NoticeUpdateDto noticeUpdateDto) {
        Notice notice1 = noticeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 공고 없음"));
        notice1.update(noticeUpdateDto);
        return noticeRepository.save(notice1);
    }
}
