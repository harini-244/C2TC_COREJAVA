package com.tns.collegeservice.service;

import com.tns.collegeservice.model.College;
import com.tns.collegeservice.repository.CollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CollegeService {
    @Autowired
    private CollegeRepository collegeRepository;

    public List<College> getAllColleges() {
        return collegeRepository.findAll();
    }

    public Optional<College> getCollegeById(Long id) {
        return collegeRepository.findById(id);
    }

    public College addCollege(College college) {
        return collegeRepository.save(college);
    }

    public College updateCollege(Long id, College collegeDetails) {
        return collegeRepository.findById(id).map(college -> {
            college.setName(collegeDetails.getName());
            college.setAddress(collegeDetails.getAddress());
            college.setCity(collegeDetails.getCity());
            college.setState(collegeDetails.getState());
            return collegeRepository.save(college);
        }).orElse(null);
    }

    public void deleteCollege(Long id) {
        collegeRepository.deleteById(id);
    }
}
