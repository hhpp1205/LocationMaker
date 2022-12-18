package kr.ac.kopo.controller;

import kr.ac.kopo.domain.ReservationDto;
import kr.ac.kopo.service.ReservationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("reserve")
public class ReservationController {
    /**
     * Domain과 URL를 일치시키는건 어떤가용?
     * reserve -> reservation
     */

    private final ReservationService reservationService;



    @GetMapping
    public String reservePage(){
        return "reservation/reservation";
    }

    @PostMapping
    public String reservedPage(ReservationDto reservationDTO) {
        if (reservationService.createReservation(reservationDTO)) {
            return "SuccessPage";
        }

        return "FailPage";
    }
}
