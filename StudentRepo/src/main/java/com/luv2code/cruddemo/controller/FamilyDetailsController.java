package com.luv2code.cruddemo.controller;

import com.luv2code.cruddemo.entity.FamilyDetails;
import com.luv2code.cruddemo.repository.FamilyDetailsRepository;
import com.luv2code.cruddemo.service.FamilyDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/familydetails")
@RequiredArgsConstructor
public class FamilyDetailsController {

    private final FamilyDetailsService detailsService;
    private final FamilyDetailsRepository familyDetailsRepository;

    @PostMapping("/createFamilyDetails")
    public ResponseEntity<FamilyDetails> createFamilyDetails(@RequestBody FamilyDetails familyDetails)
    {
        return new ResponseEntity<>(detailsService.createFamilyDetails(familyDetails), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FamilyDetails> createFamilyDetails(@PathVariable Integer id)
    {
        return new ResponseEntity<>(familyDetailsRepository.findById(id).get(), HttpStatus.OK);
    }
}
