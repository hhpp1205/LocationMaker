package kr.ac.kopo.service;

import kr.ac.kopo.dao.ServiceDao;
import kr.ac.kopo.domain.SchoolVO;
import kr.ac.kopo.util.pager.Pager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class SchoolServiceImpl implements SchoolService{

    private final ServiceDao serviceDao;

    @Override
    public List<SchoolVO> list(Pager pager) {
        pager.setTotal(serviceDao.total(pager));
        return serviceDao.list(pager);
    }

    @Override
    public void add(SchoolVO schoolVO) {
        serviceDao.add(schoolVO);
    }

    @Override
    public SchoolVO findById(int id) {
        return serviceDao.findById(id);
    }

    @Override
    public void update(SchoolVO schoolVO) {
        serviceDao.update(schoolVO);
    }

    @Override
    public void delete(int id) {
        serviceDao.delete(id);
    }
}
