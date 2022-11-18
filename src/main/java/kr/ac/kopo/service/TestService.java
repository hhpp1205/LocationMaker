package kr.ac.kopo.service;

import kr.ac.kopo.domain.SchoolVO;

import java.util.List;

public interface TestService {
    List<SchoolVO> getAllData();

    SchoolVO findById(int i);
}
