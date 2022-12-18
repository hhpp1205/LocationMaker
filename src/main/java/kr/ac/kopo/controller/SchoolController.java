package kr.ac.kopo.controller;

import kr.ac.kopo.domain.SchoolDto;
import kr.ac.kopo.service.SchoolService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("school/")
public class SchoolController {


    private final SchoolService schoolService;

    @GetMapping("add")
    public String addPage(SchoolDto schoolDTO) {
        schoolService.addSchool(schoolDTO);

        return "hihi";
    }

}
