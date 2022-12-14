package kr.ac.kopo.repository;

import kr.ac.kopo.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query(nativeQuery = true, value = "select * from reservation where start_time < :endTime and end_time > :startTime")
    List<Reservation> checkTime(@Param("startTime") LocalDateTime startTime, @Param("endTime") LocalDateTime endTime);
}
