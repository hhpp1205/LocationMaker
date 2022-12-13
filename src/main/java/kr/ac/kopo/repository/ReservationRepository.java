package kr.ac.kopo.repository;

import kr.ac.kopo.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query(nativeQuery = true, value = "select count(*) from reservation where start_time < :endTime and end_time > :startTime")
    int checkTime(@Param("startTime") LocalDateTime startTime, @Param("endTime") LocalDateTime endTime);
}
