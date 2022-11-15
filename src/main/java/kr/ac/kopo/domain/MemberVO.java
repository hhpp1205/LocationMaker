package kr.ac.kopo.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberVO {
    private int id;
    private String pwd;
    private String salt;
    private String name;
    private String major;
    private int grade;
    private String authority;
    private int schoolId;
}
