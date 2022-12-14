package kr.ac.kopo.domain;

import kr.ac.kopo.entity.School;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SchoolDTO {
    private Long id;
    private String name;
    private String call;

    public School toEntity() {
        return School.builder()
                .id(id)
                .name(name)
                .call(call)
                .build();
    }
}
