package kr.ac.kopo.entity;

import kr.ac.kopo.domain.ReservationDto;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private int headCount;

    private String purpose;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "space_id")
    private Place place;

    @Builder
    public Reservation(Long id, LocalDateTime startTime, LocalDateTime endTime, int headCount, String purpose) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.headCount = headCount;
        this.purpose = purpose;
    }

    public ReservationDto toDto() {
        return ReservationDto.builder()
                .id(id)
                .startTime(startTime)
                .endTime(endTime)
                .headCount(headCount)
                .purpose(purpose)
                .build();
    }

}
