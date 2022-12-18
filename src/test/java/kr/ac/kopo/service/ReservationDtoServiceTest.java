package kr.ac.kopo.service;

import kr.ac.kopo.domain.ReservationDto;
import kr.ac.kopo.entity.Reservation;
import kr.ac.kopo.repository.ReservationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class ReservationDtoServiceTest {

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
        ReservationDto failCase1 = new ReservationDto();
        failCase1.setStartTime(LocalDateTime.now().plusHours(3L));
        failCase1.setEndTime(LocalDateTime.now().plusHours(5L));
        boolean result1 = reservationService.createReservation(failCase1);

        ReservationDto failCase2 = new ReservationDto();
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
        ReservationDto successCase1DTO = new ReservationDto();
        successCase1DTO.setStartTime(LocalDateTime.now().plusHours(1L));
        successCase1DTO.setEndTime(LocalDateTime.now().plusHours(2L));
        boolean result1 = reservationService.createReservation(successCase1DTO);

        ReservationDto successCase2DTO = new ReservationDto();
        successCase2DTO.setStartTime(LocalDateTime.now().minusHours(3L));
        successCase2DTO.setEndTime(LocalDateTime.now().minusHours(1L));
        boolean result2 = reservationService.createReservation(successCase2DTO);

        //then
        assertThat(result1).isEqualTo(true);
        assertThat(result2).isEqualTo(true);
    }

    @Test
    void updateReservationFailCase() {
        //given
        Reservation reservation1 = new Reservation();
        reservation1.setStartTime(LocalDateTime.now());
        reservation1.setEndTime(LocalDateTime.now().plusHours(1L));
        reservationRepository.save(reservation1);

        Reservation reservation2 = new Reservation();
        reservation2.setStartTime(LocalDateTime.now().plusHours(2L));
        reservation2.setEndTime(LocalDateTime.now().plusHours(4L));
        reservationRepository.save(reservation2);

        //when
        Reservation findReservation = reservationRepository.findById(reservation1.getId()).orElseThrow(RuntimeException::new);
        findReservation.setStartTime(LocalDateTime.now().plusHours(3L));
        findReservation.setEndTime(LocalDateTime.now().plusHours(5L));
        ReservationDto findReservationDto = findReservation.toDto();
        boolean result = reservationService.updateReservation(findReservationDto);

        //then
        assertThat(result).isEqualTo(false);
    }

    @Test
    void updateReservationSuccessCase() {
        //given
        Reservation reservation1 = new Reservation();
        reservation1.setStartTime(LocalDateTime.now());
        reservation1.setEndTime(LocalDateTime.now().plusHours(1L));
        reservationRepository.save(reservation1);

        //when
        reservation1.setStartTime(LocalDateTime.now().plusHours(3L));
        reservation1.setEndTime(LocalDateTime.now().plusHours(5L));
        ReservationDto reservation1DTO = reservation1.toDto();
        boolean result = reservationService.updateReservation(reservation1DTO);

        //then
        assertThat(result).isEqualTo(true);
    }


}