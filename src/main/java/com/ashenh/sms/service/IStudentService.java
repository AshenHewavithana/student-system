package com.ashenh.sms.service;

import com.ashenh.sms.model.Students;

import java.util.List;

public interface IStudentService {
    Students addStudent(Students students);
    List<Students> getStudents();
    Students updateStudent(Students students, Long id);
    Students getStudentById(Long id);
    void deleteStudent(Long id);
}
