package kr.ac.kopo.service;

import kr.ac.kopo.entity.Reservation;
import kr.ac.kopo.repository.ReservationRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class ReservationServiceTest {

    @Autowired
    ReservationService reservationService;
    @Autowired
    ReservationRepository reservationRepository;

    @Test
    void createReservationFailCase() {
        //given
        Reservation reservation = new Reservation();
        reservation.setStartTime(LocalDateTime.now());
        reservation.setEndTime(LocalDateTime.now().plusHours(4L));
        reservationRepository.save(reservation);

        //when
        Reservation failCase1 = new Reservation();
        failCase1.setStartTime(LocalDateTime.now().plusHours(3L));
        failCase1.setEndTime(LocalDateTime.now().plusHours(5L));
        boolean result1 = reservationService.createReservation(failCase1);

        Reservation failCase2 = new Reservation();
        failCase2.setStartTime(LocalDateTime.now().minusHours(1L));
        failCase2.setEndTime(LocalDateTime.now().plusHours(1L));
        boolean result2 = reservationService.createReservation(failCase2);

        //then
        assertThat(result1).isEqualTo(false);
        assertThat(result2).isEqualTo(false);
    }

    @Test
    void createReservationSuccessCase() {
        //given
        Reservation reservation = new Reservation();
        reservation.setStartTime(LocalDateTime.now());
        reservation.setEndTime(LocalDateTime.now().plusHours(1L));
        reservationRepository.save(reservation);

        //when
        Reservation successCase1 = new Reservation();
        successCase1.setStartTime(LocalDateTime.now().plusHours(1L));
        successCase1.setEndTime(LocalDateTime.now().plusHours(2L));
        boolean result1 = reservationService.createReservation(successCase1);

        Reservation successCase2 = new Reservation();
        successCase2.setStartTime(LocalDateTime.now().minusHours(3L));
        successCase2.setEndTime(LocalDateTime.now().minusHours(1L));
        boolean result2 = reservationService.createReservation(successCase2);

        //then
        assertThat(result1).isEqualTo(true);
        assertThat(result2).isEqualTo(true);
    }


}