package com.example.entity;

import com.example.dto.StudentRequest;
import com.example.dto.StudentRequestPut;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "student")
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    public Student(StudentRequest studentRequest) {
        firstName = studentRequest.getFirstName();
        lastName = studentRequest.getLastName();
        email = studentRequest.getEmail();
    }

    public Student(Student student, StudentRequestPut studentRequest) {
        firstName = studentRequest.getFirstName() != null ? studentRequest.getFirstName() : student.getFirstName();
        lastName = studentRequest.getLastName() != null ? studentRequest.getLastName() : student.getLastName();
        email = studentRequest.getEmail() != null ? studentRequest.getEmail() : student.getEmail();
        id = studentRequest.getId();
    }
}
