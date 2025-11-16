package com.luv2code.cruddemo.service;

import com.luv2code.cruddemo.entity.EducationalDetails;
import com.luv2code.cruddemo.repository.EducationalDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EducationalDetailsService {

    private final EducationalDetailsRepository educationalDetailsRepository;

    public EducationalDetails createEducationalDetails(EducationalDetails educationalDetailsDTO) {

    return educationalDetailsRepository.save(educationalDetailsDTO);
    }
}
