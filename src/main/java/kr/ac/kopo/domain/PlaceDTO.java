package kr.ac.kopo.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlaceDTO {
    private Long id;
    private String name;
    private String location;
    private Long schoolId;
}
