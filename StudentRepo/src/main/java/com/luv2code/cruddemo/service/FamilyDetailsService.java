package com.luv2code.cruddemo.service;

import com.luv2code.cruddemo.entity.FamilyDetails;
import com.luv2code.cruddemo.repository.FamilyDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FamilyDetailsService {

    private final FamilyDetailsRepository repository;

    public FamilyDetails createFamilyDetails(FamilyDetails familyDetails) {

        return repository.save(familyDetails);
    }
}

