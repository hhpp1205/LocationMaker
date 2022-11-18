package kr.ac.kopo.dao;

import kr.ac.kopo.domain.SchoolVO;
import kr.ac.kopo.util.pager.Pager;

import java.util.List;

public interface ServiceDao {
    float total(Pager pager);

    List<SchoolVO> list(Pager pager);

    void add(SchoolVO schoolVO);

    SchoolVO findById(int id);

    void update(SchoolVO schoolVO);

    void delete(int id);
}
