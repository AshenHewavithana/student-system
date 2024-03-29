package com.ashenh.sms.service;

import com.ashenh.sms.exception.StudentAlreadyExistsException;
import com.ashenh.sms.exception.StudentNotFoundException;
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
        return studentRepository.findById(id).map(st -> {
            st.setFirstName(students.getFirstName());
            st.setLastName(students.getLastName());
            st.setDepartment(students.getDepartment());
            st.setGender(students.getGender());
            st.setEmail(students.getEmail());
            st.setFaculty(students.getFaculty());
            st.setMobileNo(students.getMobileNo());
            return studentRepository.save(st);
        }).orElseThrow(() -> new StudentNotFoundException("Sorry, could not find student!"));
    }

    @Override
    public Students getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Sorry, student with Id: " + id + " could not be found!"));
    }

    @Override
    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new StudentNotFoundException("Sorry, student with Id: " + id + " could not be found!");
        } else {
            studentRepository.deleteById(id);
        }
    }

    private boolean studentAlreadyExists(String email) {
        return studentRepository.findByEmail(email).isPresent();
    }
}
