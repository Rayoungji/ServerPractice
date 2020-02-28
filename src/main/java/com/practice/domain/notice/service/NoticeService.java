package com.practice.domain.notice.service;

import com.practice.domain.notice.domain.Notice;
import com.practice.domain.notice.domain.NoticeRepository;
import com.practice.domain.notice.dto.NoticeUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;


@RequiredArgsConstructor
@Service
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

    //모든 공고 조회
    @Transactional(readOnly = true)
    public List<Notice> getAllNotices(){
        return noticeRepository.findAllByOrderByIdAsc();
    }

    //공고 수정
    public Notice updateNotice(Long id, NoticeUpdateDto noticeUpdateDto) {
        Notice notice1 = noticeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 공고 없음"));
        notice1.update(noticeUpdateDto);
        return noticeRepository.save(notice1);
    }

    //공고 삭제
    public void deleteNotice(Long id){
        Notice notice=noticeRepository.findById(id).orElseThrow(()->new NoSuchElementException("해당 공고 없음"));
        noticeRepository.delete(notice);
    }
}
