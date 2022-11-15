package kr.ac.kopo.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ReservationVO {
    private int id;
    private Date startTime;
    private Date endTime;
    private int head_count;
    private String purpose;
    private String booker;
    private int placeId;
}
