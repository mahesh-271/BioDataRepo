package com.luv2code.cruddemo.dao;

import jakarta.persistence.*;
import lombok.*;

@Data
@ToString
@Builder(toBuilder = true)
public class StudentDao {

    private int id;
    private String firstName;
    private String lastName;
    private String email;

}
