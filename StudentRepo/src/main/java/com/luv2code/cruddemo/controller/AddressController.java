package com.luv2code.cruddemo.controller;

import com.luv2code.cruddemo.dao.StudentDao;
import com.luv2code.cruddemo.entity.Address;
import com.luv2code.cruddemo.entity.Student;
import com.luv2code.cruddemo.service.AddressService;
import com.luv2code.cruddemo.service.StudentService;
import com.luv2code.cruddemo.webclient.WebCleintClass;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/address/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable Integer id) {

        return  new ResponseEntity<>(addressService.getAddressById(id), HttpStatus.OK);
    }

}
