package com.example.controller;

import com.example.dto.StudentRequest;
import com.example.dto.StudentRequestIn;
import com.example.dto.StudentRequestPut;
import com.example.response.StudentResponse;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Value("${app.name:Some default shit}")
    private String name;

    @Autowired
    StudentService studentService;

    @DeleteMapping("/{id}")
    public String deleteStudentPath(@PathVariable("id") long id) {
        return this.studentService.deleteStudent(id);
    }

    @GetMapping()
    public List<StudentResponse> getStudent() {
        return studentService.getAllStudents();
    }

    @PostMapping()
    public void postStudent(@Valid @RequestBody StudentRequest studentRequest) {
        this.studentService.postStudent(studentRequest);
    }

    @PutMapping()
    public void putStudent(@Valid @RequestBody StudentRequestPut studentRequestPut) {
        this.studentService.updateStudent(studentRequestPut);
    }

    @DeleteMapping()
    public String deleteStudent(@RequestParam("id") Long id) {
        return this.studentService.deleteStudent(id);
    }

    @GetMapping("/firstname/{firstName}")
    public List<StudentResponse> getFirstName(@PathVariable("firstName") String firstName) {
        return this.studentService.getStudentsFirstName(firstName);
    }

    @GetMapping("/search/or")
    public List<StudentResponse> getFirstNameOrLastName(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return this.studentService.getStudentByFirstNameOrLastName(firstName, lastName);
    }

    @GetMapping("/search/and")
    public List<StudentResponse> getFirstNameAndLastName(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return this.studentService.getStudentByFirstNameAndLastName(firstName, lastName);
    }

    @GetMapping("/search/in")
    public List<StudentResponse> getFirstNameIn(@RequestBody() StudentRequestIn studentRequestIn) {
        return this.studentService.getStudentByFirstNameIn(studentRequestIn.getFirstNames());
    }

}