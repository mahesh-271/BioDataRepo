package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Address;
import com.luv2code.cruddemo.entity.EducationalDetails;
import com.luv2code.cruddemo.entity.Student;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.Value;

@Data
@Builder(toBuilder = true)
@ToString
public class StudentResponse {

    private Student student;
    private Address address;
}
