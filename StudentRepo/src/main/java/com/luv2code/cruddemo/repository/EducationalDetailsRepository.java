package com.luv2code.cruddemo.repository;

import com.luv2code.cruddemo.dao.EducationalDetailsDTO;
import com.luv2code.cruddemo.entity.Address;
import com.luv2code.cruddemo.entity.EducationalDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationalDetailsRepository extends JpaRepository<EducationalDetails, Integer> {

}
