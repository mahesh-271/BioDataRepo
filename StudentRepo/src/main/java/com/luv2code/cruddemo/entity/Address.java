package com.luv2code.cruddemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "address")
@Data
@ToString
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonIgnore
    private Integer id;

    @Column(name = "village_name")
    private String villageName;
    @Column(name = "mandal")
    private String mandal;
    @Column(name = "state")
    private String state;
    @Column(name = "pin_code")
    private int pinCode;

}

