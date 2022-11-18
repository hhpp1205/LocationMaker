package kr.ac.kopo.service;


import kr.ac.kopo.dao.TestMapper;
import kr.ac.kopo.domain.SchoolVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.TemporalType;
import java.util.List;


@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService{

    private final TestMapper testMapper;
    @Override
    public List<SchoolVO> getAllData() {
        return testMapper.getAllData();
    }

    @Override
    public SchoolVO findById(int i) {
        return testMapper.findById(i);
    }
}
