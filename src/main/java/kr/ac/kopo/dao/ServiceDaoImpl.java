package kr.ac.kopo.dao;

import kr.ac.kopo.domain.SchoolVO;
import kr.ac.kopo.util.pager.Pager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@RequiredArgsConstructor
public class ServiceDaoImpl implements ServiceDao{



    @Override
    public float total(Pager pager) {
        return 0f;
    }

    @Override
    public List<SchoolVO> list(Pager pager) {
        return null;
    }

    @Override
    public void add(SchoolVO schoolVO) {

    }

    @Override
    public SchoolVO findById(int id) {
        return null;
    }

    @Override
    public void update(SchoolVO schoolVO) {

    }

    @Override
    public void delete(int id) {

    }
}
