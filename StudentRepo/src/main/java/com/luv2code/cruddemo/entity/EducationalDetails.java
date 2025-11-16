package com.luv2code.cruddemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Education")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class EducationalDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int id;
    private String degree;
    private double degreePercentage;
    private String intermediateCollege;
    private double intermediatePercentage;
    private String sscSchool;
    private double sscPercentage;

}
