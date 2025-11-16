package com.luv2code.cruddemo.repository;

import com.luv2code.cruddemo.entity.Address;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
}
