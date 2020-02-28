package com.practice.domain.index.controller;

import com.practice.domain.notice.service.NoticeService;
import com.practice.domain.notice.dto.NoticeGetDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final NoticeService noticeService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("notices",noticeService.getAllNotices().stream().map(NoticeGetDto::new).collect(Collectors.toList()));
        return "index";
    }

    @GetMapping("/notices/update/{id}")
    public String postUpdate(@PathVariable Long id, Model model){
        model.addAttribute("notices",noticeService.getNotice(id));
        return "notices-update";
    }

    @GetMapping("/notices/save")
    public String postSave(){
        return "notices-save";
    }
}
