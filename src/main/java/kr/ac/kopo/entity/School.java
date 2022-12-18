package kr.ac.kopo.entity;

import kr.ac.kopo.domain.SchoolDto;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Data
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String call;


    @Builder
    public School(Long id, String name, String call) {
        this.id = id;
        this.name = name;
        this.call = call;
    }

    public SchoolDto toDto() {
        return SchoolDto.builder()
                .id(id)
                .name(name)
                .call(call)
                .build();
    }
}
