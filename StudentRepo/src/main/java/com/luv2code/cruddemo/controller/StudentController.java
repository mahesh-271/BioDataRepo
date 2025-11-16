package com.luv2code.cruddemo.controller;

import com.luv2code.cruddemo.dao.StudentDao;
import com.luv2code.cruddemo.entity.Student;
import com.luv2code.cruddemo.service.StudentService;
import com.luv2code.cruddemo.webclient.WebCleintClass;
import lombok.RequiredArgsConstructor;
import model.StudentDaoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private final WebCleintClass webClient;

    @GetMapping("/getStudents")
    public ResponseEntity<List<Student>> getStudent() {

        return ResponseEntity.ok(studentService.getStudents());
    }

    @GetMapping("/getStudents/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {
        return ResponseEntity.ok(studentService.getStudentsById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.updateStudentDetails(student));
    }

    @PutMapping("/edit/student")
    public ResponseEntity<Student> editStudentDetails(@RequestBody StudentDao studentDao) {
        return ResponseEntity.ok(studentService.editStudentDetails(studentDao));
    }

    @DeleteMapping("/delete/student/{id}")
    public ResponseEntity<Boolean> deleteStudent(@PathVariable Integer id) {
        return new ResponseEntity<>(studentService.deleteStudent(id), HttpStatus.OK);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Mono<StudentDaoResponse>> getStudentsDataById(@PathVariable Integer id) {
        return new ResponseEntity<>(studentService.getStudentsWithAddress(id), HttpStatus.OK);
    }

    @GetMapping("/studentsBioData/{id}")
    public ResponseEntity<Mono<StudentDaoResponse>> getStudentBioData(@PathVariable Integer id) {
        return new ResponseEntity<>(studentService.getStudentBioData(id), HttpStatus.OK);
    }


}
