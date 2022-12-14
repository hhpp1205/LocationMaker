package kr.ac.kopo.domain;

import kr.ac.kopo.entity.Reservation;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ReservationDTO {
    private Long id;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private int headCount;

    private String purpose;

    @Builder
    public ReservationDTO(Long id, LocalDateTime startTime, LocalDateTime endTime, int headCount, String purpose) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.headCount = headCount;
        this.purpose = purpose;
    }

    public Reservation toEntity() {
        return Reservation.builder()
                .id(id)
                .startTime(startTime)
                .endTime(endTime)
                .headCount(headCount)
                .purpose(purpose)
                .build();
    }



}
