package kr.ac.kopo.service;

import kr.ac.kopo.domain.ReservationDto;
import kr.ac.kopo.entity.Reservation;
import kr.ac.kopo.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ReservationService {


    private final ReservationRepository reservationRepository;


    public boolean createReservation(ReservationDto reservationDTO) {
        Reservation reservation = reservationDTO.toEntity();

        reservationDTO.toEntity();
        if (checkTime(reservation).size() == 0) {
            //예약가능 로직
            reservationRepository.save(reservation);
            return true;
        } else {
            //예약불가 로직
            return false;
        }
    }

    public boolean updateReservation(ReservationDto reservationDTO) {
        Reservation reservation = reservationDTO.toEntity();

        List<Reservation> reservations = checkTime(reservation);
        Optional<Reservation> oReservation = reservationRepository.findById(reservation.getId());

        //예약이 안겹쳤을때
        if (reservations.size() == 0) {
            Reservation updatedReservation = oReservation.orElseThrow(RuntimeException::new);

            updatedReservation.setStartTime(reservation.getStartTime());
            updatedReservation.setEndTime(reservation.getEndTime());
            updatedReservation.setHeadCount(reservation.getHeadCount());
            updatedReservation.setPurpose(reservation.getPurpose());
            return true;

            //예약이 겹쳤을 때
        } else {
            //자기 자신과 겹쳤는지 확인
            if (reservations.size() == 1) {
                if (reservations.get(0).getId() == reservation.getId()) {
                    Reservation updatedReservation = oReservation.orElseThrow(RuntimeException::new);

                    updatedReservation.setStartTime(reservation.getStartTime());
                    updatedReservation.setEndTime(reservation.getEndTime());
                    updatedReservation.setHeadCount(reservation.getHeadCount());
                    updatedReservation.setPurpose(reservation.getPurpose());
                    return true;
                }
            }
            return false;
        }
    }



    /**
     * @return 예약가능 여부
     * List.size() == 0 (시간 겹치지 않음)
     * List.size() > 0 (시간 겹침)
     */
    private List<Reservation> checkTime(Reservation reservation) {
        List<Reservation> reservations = reservationRepository.checkTime(reservation.getStartTime(), reservation.getEndTime());
        return reservations;
    }

}
