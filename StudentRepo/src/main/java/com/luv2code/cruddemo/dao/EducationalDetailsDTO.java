package com.luv2code.cruddemo.dao;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder(toBuilder = true)
@ToString
public class EducationalDetailsDTO {

    private String degree;
    private double degreePercentage;
    private String intemediateCollege;
    private double intermediatePercentage;
    private String sscSchool;
    private double sscPercentage;

}

