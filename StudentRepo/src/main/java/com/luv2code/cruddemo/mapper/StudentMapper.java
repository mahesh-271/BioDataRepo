package com.luv2code.cruddemo.mapper;

import com.luv2code.cruddemo.dao.StudentDao;
import com.luv2code.cruddemo.dao.StudentResponses;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public Student mapToStudent(StudentDao studentDao) {

        return Student.builder()
                .id(studentDao.getId())
                .email(studentDao.getEmail())
                .lastName(studentDao.getEmail())
                .firstName(studentDao.getEmail())
                .build();
    }

    public StudentResponses mapToStudentResponse(Student student){
        return StudentResponses.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .email(student.getEmail())
                .build();
    }
}
