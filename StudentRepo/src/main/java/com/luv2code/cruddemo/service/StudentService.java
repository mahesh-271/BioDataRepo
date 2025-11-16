package com.luv2code.cruddemo.service;

import com.luv2code.cruddemo.dao.StudentDao;
import com.luv2code.cruddemo.dao.StudentResponse;
import com.luv2code.cruddemo.entity.Address;
import com.luv2code.cruddemo.entity.EducationalDetails;
import com.luv2code.cruddemo.entity.FamilyDetails;
import com.luv2code.cruddemo.entity.Student;
import com.luv2code.cruddemo.gateway.Gateway;
import com.luv2code.cruddemo.mapper.StudentMapper;
import com.luv2code.cruddemo.repository.AddressRepository;
import com.luv2code.cruddemo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import model.StudentDaoResponse;
import org.hibernate.boot.cfgxml.internal.CfgXmlAccessServiceImpl;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple3;

import javax.management.RuntimeMBeanException;
import java.util.*;
import java.util.stream.Stream;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final AddressRepository addressRepository;
    private final StudentMapper studentMapper;
    private final Gateway gateway;


    public List<Student> getStudents() {
        var students = studentRepository.findAll();
        // List<Address> addresses = addressRepository.findByIds

        List<Student> resultList = students.stream().filter(Objects::nonNull).sorted(Comparator.comparing(Student::getFirstName).thenComparing(Student::getLastName)).distinct().toList();

        return resultList;
    }

    public Student getStudentsById(Integer id) {
        Student students = studentRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Student not found");
        });
        return students;
    }

    public Student editStudentDetails(StudentDao studentDao) {
        var student = studentRepository.findById(studentDao.getId()).orElseThrow(() -> new RuntimeException("Id is not foudnd"));

        if (student != null) {
            var editedStudent = studentMapper.mapToStudent(studentDao);
            return studentRepository.save(editedStudent);
        } else {
            return null;
        }
    }

    public Student updateStudentDetails(Student student) {

        boolean isPresent = studentRepository.existsById(student.getId());

        if (isPresent) {
            throw new RuntimeException("Student with id " + student.getId() + " already exists");
        }

        return studentRepository.save(student);
    }

    public Boolean deleteStudent(Integer id) {
        boolean isBoolean = false;

        studentRepository.deleteById(id);
        isBoolean = true;
        return isBoolean;
    }

    public StudentResponse getStudentResponse(Integer id) {

        var addreess = addressRepository.findById(id);

        if (!addreess.isPresent()) {
            throw new RuntimeException("Address not found");
        }
        var address = addreess.get();
        var villageName = address.getVillageName().toUpperCase();

        address.setVillageName(villageName);

        Student getStudent = null;
        if (addreess != null) {
            getStudent = this.getStudentsById(id);
        }

        var studentResponse = StudentResponse.builder().student(getStudent).address(address).build();

        return studentResponse;
    }

    public Mono<StudentDaoResponse> getStudentsWithAddress(Integer id) {
        var studentsMono = gateway.studentGateway(id);
        var addressMono = gateway.addressGateway(id);

        Mono<StudentDaoResponse> resultedMono = Mono.zip(studentsMono, addressMono)
                .map(tuple -> {
            Student student = tuple.getT1();
            Address address = tuple.getT2();

            return StudentDaoResponse
                    .builder()
                    .student(student)
                    .address(address)
                    .build();

        });

        return resultedMono;
    }


    public Mono<StudentDaoResponse> getStudentBioData(Integer id) {

        var address = gateway.addressGateway(id);
        var students = gateway.studentGateway(id);
        var educationalGateway = gateway.educationalDetails(id);
        var familyDetails = gateway.familyDetailsMono(id);


        var combinedMonos = Mono.zip(address, students, educationalGateway,familyDetails);

        return combinedMonos.map(tuple -> {
            Address address1 = tuple.getT1();
            Student student = tuple.getT2();
            EducationalDetails educationalDetails = tuple.getT3();
            FamilyDetails familyDetails1 = tuple.getT4();

            return StudentDaoResponse
                    .builder()
                    .student(student)
                    .address(address1)
                    .educationalDetails(educationalDetails)
                    .familyDetails(familyDetails1)
                    .build();
        });
    }
}
