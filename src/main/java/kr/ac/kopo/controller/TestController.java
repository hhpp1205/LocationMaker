package kr.ac.kopo.controller;


import kr.ac.kopo.domain.SchoolVO;
import kr.ac.kopo.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @GetMapping("/test")
    public String valTest(Model model){
        List<SchoolVO> list = testService.getAllData();

        SchoolVO valChk = testService.findById(1);
        System.out.println(valChk.getId());
        System.out.println(valChk.getName());
        System.out.println(valChk.getCall());

        model.addAttribute("list",list);

        return "test";
    }
}
