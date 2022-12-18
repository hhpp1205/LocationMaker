package kr.ac.kopo.domain;

import kr.ac.kopo.entity.School;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SchoolDto {
    private Long id;
    private String name;
    private String call;

    @Builder
    public SchoolDto(Long id, String name, String call) {
        this.id = id;
        this.name = name;
        this.call = call;
    }

    public School toEntity() {
        return School.builder()
                .id(id)
                .name(name)
                .call(call)
                .build();
    }
}
