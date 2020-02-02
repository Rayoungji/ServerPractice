package com.practice.service.notice;


import com.practice.domain.notice.Notice;
import com.practice.domain.notice.NoticeRepository;
import com.practice.web.notice.dto.NoticeUpdateDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringRunner;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;


@RunWith(SpringRunner.class)
public class NoticeServiceTest {

    private Logger logger= LoggerFactory.getLogger(NoticeServiceTest.class);

    @InjectMocks
    private NoticeService noticeService;

    @Mock
    private NoticeRepository noticeRepository;

    String title = "servicetest";
    String content = "servicetestcontent";
    String author = "youngji";

    Notice notice = Notice.builder()
            .title(title)
            .content(content)
            .author(author).build();

    @Test
    public void 공고등록() throws Exception {
        //given
        given(noticeRepository.save(notice)).willReturn(notice);

        //when
        Long noticeId = noticeService.saveNotice(notice);

        //then
        assertThat(noticeId).isEqualTo(notice.getId());
    }

    @Test
    public void 공고조회() throws Exception {
        //given
        given(noticeRepository.findById(1L)).willReturn(java.util.Optional.ofNullable(notice));

        //when
        Notice notice = noticeService.getNotice(1L);

        //then
        assertThat(notice.getTitle()).isEqualTo(title);
        assertThat(notice.getContent()).isEqualTo(content);
        assertThat(notice.getAuthor()).isEqualTo(author);
    }

    @Test
    public void 공고수정() throws Exception {
        //given
        NoticeUpdateDto noticeUpdateDto = NoticeUpdateDto.builder()
                .title("testtitle")
                .content("testcontent").build();

        given(noticeRepository.findById(1L)).willReturn(java.util.Optional.ofNullable(notice));
        given(noticeRepository.save(notice)).willReturn(notice);

        //when
        Notice notice = noticeService.updateNotice(1L, noticeUpdateDto);

        //then
        assertThat(notice.getContent()).isEqualTo(noticeUpdateDto.getContent());
        logger.info(notice.getContent());
        assertThat(notice.getTitle()).isEqualTo(noticeUpdateDto.getTitle());
        logger.info(notice.getTitle());
    }
}
