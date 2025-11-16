package com.luv2code.cruddemo.repository;

import com.luv2code.cruddemo.entity.FamilyDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyDetailsRepository extends JpaRepository<FamilyDetails, Integer> {
}
