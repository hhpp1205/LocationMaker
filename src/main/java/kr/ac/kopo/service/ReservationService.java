package kr.ac.kopo.service;

import kr.ac.kopo.entity.Reservation;
import kr.ac.kopo.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;


    public boolean createReservation(Reservation reservation) {
        if (checkTime(reservation)) {
            //예약가능 로직
            reservationRepository.save(reservation);
            return true;
        } else {
            //예약불가 로직
            return false;
        }

    }

    private boolean checkTime(Reservation reservation) {
        int count = reservationRepository.checkTime(reservation.getStartTime(), reservation.getEndTime());

        if (count > 0)
            return false; // 0보다 크면 중복
        else
            return true;  // 0이면 예약가능
    }

}
