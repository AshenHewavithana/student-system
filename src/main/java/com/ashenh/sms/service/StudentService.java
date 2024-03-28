package com.ashenh.sms.service;

import com.ashenh.sms.model.Students;
import com.ashenh.sms.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentService implements IStudentService{
    private final StudentRepository studentRepository;
    @Override
    public Students addStudent(Students students) {
        if (studentAlreadyExists(students.getEmail())) {
            throw new StudentAlreadyExistsException(students.getEmail() + " already exists!");
        }
        return studentRepository.save(students);
    }

    @Override
    public List<Students> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Students updateStudent(Students students, Long id) {
        return null;
    }

    @Override
    public Students getStudentById(Long id) {
        return null;
    }

    @Override
    public void deleteStudent(Long id) {

    }
}
