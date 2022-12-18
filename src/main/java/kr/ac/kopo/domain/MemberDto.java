package kr.ac.kopo.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto {
    private Long id;
    private String loginId;
    private String pwd;
    private String salt;
    private String name;
    private String major;
    private int grade;
    private String authority;
    private Long schoolId;
}
