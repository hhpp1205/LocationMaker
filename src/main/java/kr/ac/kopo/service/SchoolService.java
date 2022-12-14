package kr.ac.kopo.service;

import kr.ac.kopo.domain.SchoolDTO;
import kr.ac.kopo.entity.School;
import kr.ac.kopo.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class SchoolService {

    private final SchoolRepository schoolRepository;

    public School addSchool(SchoolDTO schoolDTO) {
        School school = schoolDTO.toEntity();
        return schoolRepository.save(school);
    }

}
