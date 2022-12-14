package kr.ac.kopo.controller;

import kr.ac.kopo.domain.ReservationDTO;
import kr.ac.kopo.service.ReservationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ReservationService reservationService;

    @GetMapping("/")
    public String HomePage() {
        return "main/main";
    }

    @GetMapping("/reserve")
    public String reservePage(){
        return "reservation/reservation";
    }

    @PostMapping("/reserve")
    public String reservedPage(ReservationDTO reservationDTO) {
        if (reservationService.createReservation(reservationDTO)) {
            return "SuccessPage";
        }

        return "FailPage";
    }
}
