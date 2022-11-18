package kr.ac.kopo.dao;

import kr.ac.kopo.domain.SchoolVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TestMapper {
    List<SchoolVO> getAllData();

    SchoolVO findById(int i);
}
