package com.example.service;

import com.example.dto.StudentRequest;
import com.example.dto.StudentRequestPut;
import com.example.entity.Student;
import com.example.repository.StudentRepository;
import com.example.response.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.swing.text.Style;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public List<StudentResponse> getAllStudents() {
        List<Student> students = this.studentRepository.findAll();
        List<StudentResponse> studentsRes = new ArrayList<>();
        students.stream().forEach(student -> {
            studentsRes.add(new StudentResponse(student));
        });
        return  studentsRes;
    }

    public StudentResponse postStudent(StudentRequest studentRequest) {
        Student student = new Student(studentRequest);
        student = studentRepository.save(student);
        return new StudentResponse(student);
    }

    public StudentResponse updateStudent(StudentRequestPut studentRequest) {
        Student student = studentRepository.findById(studentRequest.getId()).get();
        student = new Student(student, studentRequest);
        studentRepository.save(student);
        return new StudentResponse(student);
    }

    public String deleteStudent(Long id) {
        Student student = studentRepository.getById(id);
        studentRepository.delete(student);
        return "Student deleted successfully";
    }

    public List<StudentResponse> getStudentsFirstName(String firstName) {
        List<Student> students = studentRepository.findByFirstName(firstName);
        List<StudentResponse> studentsRes = new ArrayList<>();
        students.stream().forEach(student -> {
            studentsRes.add(new StudentResponse(student));
        });
        return  studentsRes;
    }

    public List<StudentResponse> getStudentByFirstNameAndLastName(String firstName, String lastName) {
        List<Student> students = studentRepository.findByFirstNameAndLastName(firstName, lastName);
        List<StudentResponse> studentsRes = new ArrayList<>();
        students.stream().forEach(student -> {
            studentsRes.add(new StudentResponse(student));
        });
        return  studentsRes;
    }

    public List<StudentResponse> getStudentByFirstNameOrLastName(String firstName, String lastName) {
        List<Student> students = studentRepository.findByFirstNameOrLastName(firstName, lastName);
        List<StudentResponse> studentsRes = new ArrayList<>();
        students.stream().forEach(student -> {
            studentsRes.add(new StudentResponse(student));
        });
        return  studentsRes;
    }

    public List<StudentResponse> getStudentByFirstNameIn(List<String> firstNames) {
        List<Student> students = this.studentRepository.findByFirstNameIn(firstNames);
        List<StudentResponse> studentsRes = new ArrayList<>();
        students.stream().forEach(student -> {
            studentsRes.add(new StudentResponse(student));
        });
        return  studentsRes;
    }
}
