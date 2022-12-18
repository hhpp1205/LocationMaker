package kr.ac.kopo.service;

import kr.ac.kopo.domain.SchoolDto;
import kr.ac.kopo.entity.School;
import kr.ac.kopo.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class SchoolService {

    private final SchoolRepository schoolRepository;

    public void addSchool(SchoolDto schoolDTO) {
        School school = schoolDTO.toEntity();
        schoolRepository.save(school);
    }

    public void updateSchool(SchoolDto schoolDTO) {
        Optional<School> findSchool = schoolRepository.findById(schoolDTO.getId());
        if (findSchool.isEmpty()) {
            throw new NoSuchElementException("학교를 찾지 못했습니다.");
        }

        School school = findSchool.get();
        school.setName(school.getName());
        school.setCall(school.getCall());
    }

    public SchoolDto findSchoolById(Long schoolId) {
        School school = schoolRepository.findById(schoolId).orElseThrow(NoSuchElementException::new);
        return school.toDto();
    }

    public void deleteSchoolById(Long schoolId) {
        schoolRepository.deleteById(schoolId);
    }

    public List<SchoolDto> findAllSchool() {
        List<School> schools = schoolRepository.findAll();

        List<SchoolDto> schoolDtoList = new ArrayList<>();
        for (School school : schools) {
            SchoolDto schoolDTO = school.toDto();
            schoolDtoList.add(schoolDTO);
        }

        return schoolDtoList;
    }



}
