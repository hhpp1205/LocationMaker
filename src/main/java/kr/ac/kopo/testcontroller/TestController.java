package kr.ac.kopo.testcontroller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/test")
public class TestController {

    @GetMapping("/main")
    public String testMainPage() {
        return "main/main";
    }

    @GetMapping("/reserve")
    public String testReservePage() {
        return "reservation/reservation";
    }
}
