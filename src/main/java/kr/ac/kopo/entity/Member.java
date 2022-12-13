package kr.ac.kopo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String loginId;

    private String pwd;

    private String salt;

    private String name;

    private String major;

    private String grade;

    private String authority;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    @OneToMany
    private List<Reservation> reservations;

}
