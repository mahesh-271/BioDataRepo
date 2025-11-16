package com.luv2code.cruddemo.dao;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder(toBuilder = true)
public class StudentResponses {

    private int id;
    private String firstName;
    private String lastName;
    private String email;

}
