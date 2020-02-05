package com.practice.domain;

import com.practice.domain.notice.Notice;
import com.practice.domain.notice.NoticeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaBasePersistableTest {

    @Autowired
    private NoticeRepository noticeRepository;

    @Test
    public void BaseTimeEntity_등록() throws Exception{
        //given
        LocalDateTime now = LocalDateTime.of(2020, 02, 02, 0, 0, 0);
        noticeRepository.save(Notice.builder()
        .title("a")
        .content("b")
        .author("c").build());

        //when
        List<Notice> notices = noticeRepository.findAll();

        //then
        Notice notice = notices.get(0);

        System.out.println(">>>>> createDate = " + notice.getCreatedDate() + ", modifiedDate = " + notice.getModifiedDate());

        assertThat(notice.getCreatedDate()).isAfter(now);
        assertThat(notice.getModifiedDate()).isAfter(now);
    }
}
