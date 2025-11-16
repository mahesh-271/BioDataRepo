package com.luv2code.cruddemo.controller;

import com.luv2code.cruddemo.dao.EducationalDetailsDTO;
import com.luv2code.cruddemo.entity.EducationalDetails;
import com.luv2code.cruddemo.repository.EducationalDetailsRepository;
import com.luv2code.cruddemo.service.EducationalDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/educationaldetails")
public class EducationalDetailsController {

    private final EducationalDetailsService educationalDetailsService;
    private final EducationalDetailsRepository educationalDetailsRepository;

    @PostMapping("/create")
    public ResponseEntity<EducationalDetails> createEducationalDetails(@RequestBody EducationalDetails educationalDetailsDTO) {

        return new ResponseEntity<>(educationalDetailsService.createEducationalDetails(educationalDetailsDTO),
                HttpStatus.CREATED);
    }

    @GetMapping("/getEducationalDetails/{id}")
    public ResponseEntity<EducationalDetails> getEducationalDetails(@PathVariable Integer id)
    {
        return new ResponseEntity<>(educationalDetailsRepository.findById(id).get(),HttpStatus.OK);
    }
}
