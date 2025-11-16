package com.luv2code.cruddemo.mapper;

import com.luv2code.cruddemo.dao.StudentDao;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public Student mapToStudent(StudentDao studentDao)
    {

        var student   = Student.builder()
                .id(studentDao.getId())
                .email(studentDao.getEmail())
                .lastName(studentDao.getEmail())
                .firstName(studentDao.getEmail())
                .build();
        return student;
    }


}
