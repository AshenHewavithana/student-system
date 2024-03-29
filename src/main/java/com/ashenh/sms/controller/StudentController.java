package com.ashenh.sms.controller;

import com.ashenh.sms.model.Students;
import com.ashenh.sms.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final IStudentService studentService;

    @GetMapping
    public ResponseEntity<List<Students>> getStudents() {
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.FOUND);
    }

    @PostMapping
    public Students addStudent(@RequestBody Students students) {
        return studentService.addStudent(students);
    }

    @PutMapping("/update/{id}")
    public Students updateStudent(@RequestBody Students students,@PathVariable Long id) {
        return studentService.updateStudent(students, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    @GetMapping("/{id}")
    public Students getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }
}
