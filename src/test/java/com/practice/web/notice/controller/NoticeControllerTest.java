package com.practice.web.notice.controller;

import com.practice.domain.notice.Notice;
import com.practice.domain.notice.NoticeRepository;
import com.practice.web.notice.dto.NoticeSaveDto;
import com.practice.web.notice.dto.NoticeUpdateDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class NoticeControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private NoticeRepository noticeRepository;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @After
    public void cleanup() throws Exception {
        noticeRepository.deleteAll();
    }

    @Test
    public void 공고등록테스트() throws Exception {
        //given
        String title = "test";
        String content = "contenttest";
        String author = "youngji";

        NoticeSaveDto noticeSaveDto = NoticeSaveDto.builder()
                .title(title)
                .content(content)
                .author(author).build();

        String url = "http://localhost:" + port + "/api/v1/notices";

        //when
        ResponseEntity<Long> responseEntity = testRestTemplate.postForEntity(url, noticeSaveDto, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isNotNull();
        List<Notice> all = noticeRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(title);
        assertThat(all.get(0).getContent()).isEqualTo(content);
        assertThat(all.get(0).getAuthor()).isEqualTo(author);
    }

    @Test
    public void 공고조회테스트() throws Exception {
        //given
        Long id = 1L;
        String url = "http://localhost:" + port + "/api/v1/notices/" + id;

        String title = "test";
        String content = "contenttest";
        String author = "youngji";

        noticeRepository.save(Notice.builder()
                .title(title)
                .content(content)
                .author(author).build());

        //when
        ResponseEntity<Object> responseEntity = testRestTemplate.getForEntity(url, Object.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isNotNull();
        List<Notice> all = noticeRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(title);
        assertThat(all.get(0).getContent()).isEqualTo(content);
        assertThat(all.get(0).getAuthor()).isEqualTo(author);
    }

    @Test
    public void 공고수정테스트() throws Exception {
        //given
        String title = "test";
        String content = "contenttest";
        String author = "youngji";

        noticeRepository.save(Notice.builder()
                .title(title)
                .content(content)
                .author(author).build());

        Long id = 1L;

        NoticeUpdateDto noticeUpdateDto = NoticeUpdateDto.builder()
                .title("updatetest")
                .content("updatecontent").build();

        String url = "http://localhost:" + port + "/api/v1/notices/" + id;

        HttpEntity<NoticeUpdateDto> httpEntity = new HttpEntity<>(noticeUpdateDto);

        //when
        ResponseEntity<Object> responseEntity = testRestTemplate.exchange(url, HttpMethod.PUT, httpEntity, Object.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isNotNull();
        List<Notice> all = noticeRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo("updatetest");
        assertThat(all.get(0).getContent()).isEqualTo("updatecontent");
    }
}
